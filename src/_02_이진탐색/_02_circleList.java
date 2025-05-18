package _02_이진탐색;

public class _02_circleList {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 8, 0, 1, 2};

        int len = nums.length;

    }

    public static int binarySearch(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(target > arr[mid] && target <= arr[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }
}
