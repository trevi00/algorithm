package _01_정렬;

public class _02_SelectSort {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{1, 4, 2, 5, 3};

        for(int i = 0; i < arr.length-1; i++){
            int min = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int tmp = arr[min];
            arr[min] =  arr[i];
            arr[i] = tmp;

        }

    }
}
