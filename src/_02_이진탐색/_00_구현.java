package _02_이진탐색;

import java.util.ArrayDeque;
import java.util.Arrays;

public class _00_구현 {
    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 9, 4, 5, 8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int idx = binarySearch(arr, 0, arr.length, 7);
        System.out.println(idx);
        System.out.println("- - -");
        System.out.println(Arrays.binarySearch(arr, 7));
    }

    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) return mid;
        else if (arr[mid] > target)
            return binarySearch(arr, left, mid - 1, target); // 왼쪽 반 검색
        else
            return binarySearch(arr, mid + 1, right, target); // 오른쪽 반 검색
    }
}
