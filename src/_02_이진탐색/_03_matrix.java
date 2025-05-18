package _02_이진탐색;

public class _03_matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 7, 8},
                {10, 11, 15, 20},
                {21, 30, 35, 60}
        };

        System.out.println(ps(matrix, 3));
    }

    public static boolean ps(int[][] matrix, int target) {
        if(matrix == null || matrix.length==0) return false;

        int left = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int right = rows*cols - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if(matrix[mid/cols][mid%cols] == target){
                return true;
            } else if(matrix[mid/cols][mid%cols] < target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }
}
