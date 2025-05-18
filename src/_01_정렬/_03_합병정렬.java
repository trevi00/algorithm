package _01_정렬;

import java.util.Arrays;

public class _03_합병정렬 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    // 반으로 쪼개고
    // 왼쪽과 중간부터 비교하며 tmp배열에 넣음
    // 정렬이 끝나면 절반을 쪼개서 다시

    public static void merge(int[] arr, int[] tmp,
                             int left, int right,
                             int mid) {
        int p = left;
        int q = mid + 1;
        int idx = p;

        while(p <= mid || q <= right){
            if(p <= mid && q <= right) {
                if (arr[p] <= arr[q]) {
                    tmp[idx++] = arr[p++];
                } else {
                    tmp[idx++] = arr[q++];
                }
            } else if (p <= mid && q > right){
                tmp[idx++] = arr[p++];
            } else {
                tmp[idx++] = arr[q++];
            }
        }

        for(int i = left; i <= right; i++){
            arr[i] = tmp[i];
        }
    }

    public static void mergeSort(int[] arr, int[] tmp,
                                 int left, int right) {
        if(left<right){
            int mid = left + (right-left)/2;
            mergeSort(arr, tmp, left, mid);
            mergeSort(arr, tmp, mid+1, right);
            merge(arr, tmp, left, right, mid);
        }
    }
}
