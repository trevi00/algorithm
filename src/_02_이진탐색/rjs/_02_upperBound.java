package _02_이진탐색.rjs;

public class _02_upperBound {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3, 3, 5, 5, 5, 7, 9, 10};

        int k = 5;

        System.out.println(upperBound(k, arr, 0, arr.length-1));
    }

    static int upperBound(int k, int[] arr, int left, int right){
        if(left>right) {
            if (left >= arr.length) return -1;
            return right;
        }

        int mid = left + (right-left)/2;
        // 1 2 3 4 4 4 5
        if(arr[mid] > k) right = mid-1;
        else left = mid+1;

        return upperBound(k, arr, left, right);
    }
}
