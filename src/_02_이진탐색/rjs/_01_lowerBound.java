package _02_이진탐색.rjs;

public class _01_lowerBound {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 4, 5, 5, 5, 5,
                6, 7, 8, 8, 8, 8, 8, 9, 10};

        int k = 3;

        System.out.println(lowerBound(5, arr, 0, arr.length-1));
    }

    static int lowerBound(int k, int[] arr, int left, int right){
        if(left > right) {
            if(right<0) return -1;
            return left;
        }

        int mid = left + (right - left)/2;

        // 1 2 3 4 4 5 6 7 8
        if(arr[mid] >= k) right = mid-1;
        else left = mid+1;

        return lowerBound(k, arr, left, right);
    }
}
