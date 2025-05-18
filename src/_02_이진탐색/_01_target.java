package _02_이진탐색;

public class _01_target {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};
        int idx = binarySearch(arr, 3);
        System.out.println(idx);
    }

    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;

            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) left = mid+1;
            else right = mid-1;
        }

        return -left -1;
    }
}
