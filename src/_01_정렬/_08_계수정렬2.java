package _01_정렬;

import java.util.*;

public class _08_계수정렬2 {

    public static void main(String[] args) {
        int[] arr = {10, 32, 10, 27, 32, 17, 99, 56};

        countingSort(arr);

        System.out.println("계수정렬 : " + Arrays.toString(arr));
    }

    static void countingSort(int[] arr) {
        // 자료가 클때
        Map<Integer, Integer> map = new HashMap<>();
        for(int item:arr) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        int idx = 0;
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            int cnt = map.get(list.get(i));
            while(cnt > 0) {
                arr[idx++] = list.get(i);
                cnt--;
            }
        }
    }
}
