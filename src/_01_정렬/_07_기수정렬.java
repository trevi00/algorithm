package _01_정렬;

import java.util.*;

public class _07_기수정렬 {
    public static void main(String[] args) {
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        radixSort(arr);

        System.out.println("기수 정렬 : " + Arrays.toString(arr));
    }

    static void radixSort(int[] arr){
        
        // 기수 테이블 만들기
        List<Queue<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(new LinkedList<>());
        }

        int idx = 0;
        int div = 1;
        int maxLen = getMaxLen(arr); // 자리수 얻기

        // 자리수만큼 반복
        for (int i = 0; i < maxLen; i++) {
            for(int j = 0; j < arr.length; j++){
                list.get((arr[j]/div)%10).offer(arr[j]);
            }

            for (int j = 0; j < 10; j++) {
                Queue<Integer> queue = list.get(j);

                while(!queue.isEmpty()){
                    arr[idx++] = queue.poll();
                }
            }

            idx = 0;
            div *= 10;
        }

    }

    static int getMaxLen(int[] arr){
        int maxLen = 0;
        for(int i = 0; i < arr.length; i++){
            int len = (int) Math.log10(arr[i]) + 1;
            if(maxLen < len) {
                maxLen = len;
            }
        }
        return maxLen;
    }
}
