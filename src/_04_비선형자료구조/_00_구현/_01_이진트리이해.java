package _04_비선형자료구조._00_구현;

class BinaryTree {
    char[] arr;

    BinaryTree(char[] data){
        this.arr = data.clone();
    }

    public void preOrder(int idx){
        System.out.println(this.arr[idx] + " ");

        int left = 2*idx+1;
        int right = 2*idx+2;

        if(left < this.arr.length)
            preOrder(left);
        if(right < this.arr.length)
            preOrder(right);
    }

    public void inOrder(int idx){
        int left = 2*idx+1;
        int right = 2*idx+2;

        if(left < this.arr.length)
            inOrder(left);
        System.out.print(this.arr[idx] + " ");
        if(right < this.arr.length)
            inOrder(right);
    }

    public void postOrder(int idx){
        int left = 2*idx+1;
        int right = 2*idx+2;

        if(left < this.arr.length)
            postOrder(left);
        if(right < this.arr.length)
            postOrder(right);
        System.out.print(this.arr[idx] + " ");
    }

}

public class _01_이진트리이해 {
    public static void main(String[] args) {
        //Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree tree = new BinaryTree(arr);
        tree.preOrder(0);
        System.out.println();
        tree.inOrder(0);
        System.out.println();
        tree.postOrder(0);
    }


}
