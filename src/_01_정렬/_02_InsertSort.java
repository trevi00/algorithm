package _01_정렬;

public class _02_InsertSort {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{1, 4, 2, 5, 3};

        for(int i = 1; i < arr.length; i++){
            for(int j = i; j >= 0; j--){
                if(arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }

    }
}
