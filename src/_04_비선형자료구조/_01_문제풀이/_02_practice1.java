package _04_비선형자료구조._01_문제풀이;

// practice1
// 종이접기
// 종이를 반으로 접었을 때, 안으로 파인 부분은 0, 볼록 튀어나온 부분은 1이라고 하자.
// 종이를 N번 접었을 때의 접힌 상태를 출력하는 문제를 작성하세요.

// 입출력 예시
// 입력 : 1
// 출력 : 0

// 입력 : 2
// 출력 : 0, 0, 1

// 입력 : 3
// 출력 : 0, 0, 1, 0, 0, 1, 1

public class _02_practice1 {
    public static void solution(int n){
        int[] binaryTree = new int[(int) Math.pow(2, n)];

        binaryTree[0] = 0;
        for (int i = 0; i < (int) Math.pow(2, n-1)-1; i++) {
            binaryTree[i*2+1] = 0;
            binaryTree[i*2+2] = 1;
        }

        inOrder(binaryTree, 0);
        System.out.println();
    }

    public static void inOrder(int[] arr, int idx){
        int left = idx*2+1;
        int right = idx*2+2;

        if(left < arr.length - 1){
            inOrder(arr, left);
        }

        System.out.print(arr[idx] + " ");

        if(right < arr.length - 1){
            inOrder(arr, right);
        }
    }

    public static void main(String[] args) {
        solution(1);
        solution(2);
        solution(3);
    }
}
