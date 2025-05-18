package _01_정렬;

import java.util.ArrayList;
import java.util.List;

public class _01_bubbleSort {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{1, 4, 2, 5, 3};

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

    }
}
