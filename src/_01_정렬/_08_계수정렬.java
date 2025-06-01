package _01_정렬;

import java.util.*;

public class _08_계수정렬 {

    public static void main(String[] args) {
        int[] arr = {10, 32, 10, 27, 32, 17, 99, 56};

        countingSort(arr);

        System.out.println("계수정렬 : " + Arrays.toString(arr));
    }

    static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] cntArr = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            cntArr[arr[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < cntArr.length; i++) {
            while (cntArr[i] > 0) {
                arr[idx++] = i;
                cntArr[i]--;
            }
        }
    }
}
