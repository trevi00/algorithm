package _01_정렬;

import java.util.Arrays;

public class _04_힙정렬 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        for (int i = arr.length/2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        for (int i = arr.length-1; i > 0; i++) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, 0, i);
        }
    }

    public static void heapify(int[] arr, int parentIdx, int size){
        int leftIdx = 2 * parentIdx + 1;
        int rightIdx = 2 * parentIdx + 2;
        int maxIdx = parentIdx;

        if(leftIdx < size && arr[maxIdx] < arr[leftIdx]){
            maxIdx = leftIdx;
        }

        if(rightIdx < size && arr[maxIdx] < arr[rightIdx]){
            maxIdx = rightIdx;
        }

        if(parentIdx != maxIdx){
            int tmp = arr[maxIdx];
            arr[maxIdx] = arr[parentIdx];
            arr[parentIdx] = tmp;
            heapify(arr, maxIdx, size);
        }
    }
}
