package _02_이진탐색.rjs;

public class _03_카운팅 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 4, 5, 5, 5, 5, 6, 7, 8, 8, 8, 8, 8, 9, 10};

        int k = 5;
        int lower = lowerBound(k, arr, 0, arr.length - 1);
        int upper = upperBound(k, arr, 0, arr.length - 1);

        if (lower == -1 || upper == -1 || lower >= arr.length || arr[lower] != k) {
            System.out.println("값 " + k + "는 배열에 없습니다.");
        } else {
            int count = upper - lower;
            System.out.println("값 " + k + "의 등장 횟수: " + count);
        }
    }

    // arr[i] >= k인 첫 번째 인덱스
    static int lowerBound(int k, int[] arr, int left, int right) {
        if (left > right) {
            if (left >= arr.length || arr[left] < k) return -1;
            return left;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] >= k) {
            return lowerBound(k, arr, left, mid - 1);
        } else {
            return lowerBound(k, arr, mid + 1, right);
        }
    }

    // arr[i] > k인 첫 번째 인덱스
    static int upperBound(int k, int[] arr, int left, int right) {
        if (left > right) {
            if (left >= arr.length) return arr[arr.length - 1] <= k ? -1 : left;
            return left;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] > k) {
            return upperBound(k, arr, left, mid - 1);
        } else {
            return upperBound(k, arr, mid + 1, right);
        }
    }
}
