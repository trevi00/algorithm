package _03_투포인터;

import java.util.Arrays;

public class _01_target {
    static int[] forLoop(int[] arr, int target){
        int[] result = {-1, -1};

        for(int i = 0; i < arr.length; i++){
            int sum = arr[i];
            for(int j = i+1; j < arr.length; j++){
                if(sum == target){
                    result[0] = i;
                    result[1] = j-1;
                    break;
                }
                sum += arr[j];
            }
            if(sum == target) break;
        }
        return result;
    }

    static int[] twoPointer(int[] arr, int target){
        int left = 0;
        int right = 0;

        int sum = 0;
        for(right = 0; right < arr.length; right++){
            if(sum > target) {
                sum -= arr[left++];
                right--;
            } else {
                sum += arr[right];
            }

            if(sum == target) break;
        }

        if(right == arr.length) right--;
        int[] result = {left, right};
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 7, 2, 4, 3, 2};
        System.out.println(Arrays.toString(twoPointer(arr, 9)));
        System.out.println(Arrays.toString(twoPointer(arr, 14)));
    }
}
