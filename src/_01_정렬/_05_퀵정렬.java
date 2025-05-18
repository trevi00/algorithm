package _01_정렬;

import java.util.Arrays;

public class _05_퀵정렬 {
    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 9, 4, 5, 8};

        // pivot을 고른다
        // 투포인터가 양끝점에서 다가온다.
        // left = pivot보다 큰값
        // right = pivot보다 작은값
        // 찾으면 자리를 바꿔준다.
        // 종료가 되었을때, pivot은 마지막 left와 자리를 바꾼다.
        // pivot을 기준으로 절반을 나눈다.
        // 이제는 각각의 왼쪽의 요솟수가 pivot이 된다.

        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right){
        if(left>=right) return;

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot-1);
        quickSort(arr, pivot+1, right);
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = arr[left];
        int i = left;
        int j = right;

        while(i < j){
            while(arr[j] > pivot && i < j){
                j--;
            }

            while(arr[i] <= pivot && i < j){
                i++;
            }

            swap(arr, i, j);
        }
        swap(arr, left, i);

        return i;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
