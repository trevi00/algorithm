package _02_이진탐색;

// 정수형 배열 nums와 정수 m이 주어진다
// nums에는 양의 정수 값들이 들어있고, m은 배열을 부분 배열로 분리할 수 있는 수이다.
// nums배열을 m개의 부분 배열로 분리할때,
// 각 부분 배열의 합 중 가장 큰 값이 최소가 되도록 분리했을 때의 합을 출력하세요.

// 입출력 예시
// nums : 7 2 5 10 8
// m : 2
// 출력 : 18

// nums : 1 2 3 4 5
// m : 2
// 출력 : 9

// m개만큼 분할하고 싶다.
// 각 부분 배열의 합 중 가장 큰 값이 최소가 되도록 분리했을 때의 합을 출력하세요.

import java.util.Arrays;
import java.util.Map;

public class _05_데이터탐색 {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        Arrays.sort(nums);
        System.out.println(solution(nums, 2));

        nums = new int[]{1, 2, 3, 4, 5};
        Arrays.sort(nums);
        System.out.println(solution(nums, 2));
    }

    static int solution(int[] nums, int m){
        int left = 0;
        int right = 0;

        for(int n : nums){
            left = Math.max(left, n);
            right += n;
        }

        while(left <= right){
            int mid = left + (right-left)/2;
            int cnt = 1;
            int cur = 0;

            for(int n : nums){
                if(cur + n > mid){
                    cnt+=1;
                    cur = 0;
                }
                cur += n;
            }

            if(cnt > m){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}
