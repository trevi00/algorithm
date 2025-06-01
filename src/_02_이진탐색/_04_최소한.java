package _02_이진탐색;


// 정수형 배열 weights와 정수 days가 주어졌다.
// weights에는 각 상품의 무게들의 정보가 들어있고,
// days는 운송 납기일이다.
// 상품들은 weights에 적혀있는 순서대로 실어서 운송해야 하는데,
// days이내에 운송을 하기 위한 차량의
// 최소한의 적재량을 계산하는 프로그램을 작성하세요.

// 입출력 예시
// weights : 1, 2, 3, 4, 5, 6, 7, 8, 9,10
// days : 5
// 출력 : 15

// weights : 3, 2, 2, 4, 1, 4
// days : 3
// 출력 : 6


// 문제 해석
// 총 55의 무게
// 최소값으로는 10으로 잡음 (최소 적재량은 낱개중 큰값으로)
// 적재량이 55일때는 하루만에 가능
// 10~55니까 절반값은 32(소수점제외)
// 적재량이 32면 1~7 8~10 2일이면 됨. 아직도 너무 적음
// 적재량이 10+32 /2 21이면? 3일
// 적재량이 10+21 /2 15이면? 5일

public class _04_최소한 {
    public static int solution(int[] weights, int days){
        int left = 0;
        int right = 0;

        for(int w : weights){
            left = Math.max(left, w);
            right += w;
        }

        while(left <= right){
            int mid = left + (right-left)/2;
            int cnt = 1;
            int cur = 0;

            for(int w : weights){
                if(cur + w > mid) {
                    cnt += 1;
                    cur = 0;
                }
                cur += w;
            }

            if(cnt > days) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution(weights, 5));

        weights = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(solution(weights, 3));
    }


}
