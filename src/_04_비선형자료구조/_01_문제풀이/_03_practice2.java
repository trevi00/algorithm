package _04_비선형자료구조._01_문제풀이;

// practice2
// 각각의 에지에 가중치가 있는 포화 이진트리가 있다.
// 루트에서 각 리프까지의 경로 길이를 모두 같게 설정하고,
// 이 때, 모든 가중치들의 총합이 최소가 되도록 하는 프로그램을 작성하세요.

class BinaryTree03 {
    int h;
    int[] arr;
    int res;

    public BinaryTree03(int h, int[] w) {
        this.h = h;
        this.arr = new int[(int)Math.pow(2, h+1)];
        this.res = 0;

        for (int i = 0; i < (int) Math.pow(2, h+1); i++) {
            arr[i] = w[i-2];
        }
    }

    public int dfs(int idx, int h) {
        if(this.h == h) {
            res += arr[idx];
            return arr[idx];
        }

        int left = dfs(idx*2, h+1);
        int right = dfs(idx*2+1, h+1);
        res += arr[idx] + Math.abs(left - right);
        return arr[idx] + Math.max(left, right);
    }
}

public class _03_practice2 {
    public static void solution(int h, int[] w){
        BinaryTree03 bt = new BinaryTree03(h, w);
        bt.dfs(1, 0);
        System.out.println(bt.res);
    }

    public static void main(String[] args) {
        int h = 2;
        int[] w = {2, 2, 2, 1, 1, 3};
        solution(h, w);
        System.out.println();

        h = 3;
        w = new int[]{1, 2, 1, 3, 2, 4, 1, 1, 1, 1, 1, 1, 1, 1};
        solution(h, w);

    }
}
