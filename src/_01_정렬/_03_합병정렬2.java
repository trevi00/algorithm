package _01_정렬;

import java.util.Arrays;
import java.util.List;

public class _03_합병정렬2 {
    static List<Integer> arr;
    static int[] temp;

    public static void main(String[] args) {
        arr = Arrays.asList(new Integer[]{3, 5, 2, 7, 1, 4, 6});
        temp = new int[arr.size()];

        mergeSort(0, arr.size()-1);

        System.out.println(Arrays.toString(arr.toArray()));
    }

    static void mergeSort(int left, int right){
        if(left>=right) return;

        int mid = left+(right-left)/2;

        mergeSort(left, mid);
        mergeSort(mid+1, right);

        int l = left;
        int r = mid+1;

        int idx = 0;

        while(l <= mid && r <= right){
            if(arr.get(l) < arr.get(r)) temp[idx++] = arr.get(l++);
            else temp[idx++] = arr.get(r++);
        }

        while(l <= mid) temp[idx++] = arr.get(l++);
        while(r <= right) temp[idx++] = arr.get(r++);

        for (int i = 0; i < idx; i++) {
            arr.set(left+i, temp[i]);
        }
    }
}
