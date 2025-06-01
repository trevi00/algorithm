package _04_비선형자료구조._00_구현;

import java.util.LinkedList;
import java.util.Queue;

class NODE {
    char data;
    NODE left;
    NODE right;

    public NODE(char data, NODE left, NODE right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree2 {
    NODE head;

    public BinaryTree2() {
    }

    public BinaryTree2(char[] arr) {
        NODE[] nodes = new NODE[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new NODE(arr[i], null, null);
        }

        for (int i = 0; i < arr.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if(left < arr.length)
                nodes[i].left = nodes[left];
            if(right < arr.length)
                nodes[i].right = nodes[right];
        }
        this.head = nodes[0];
    }

    public void preOrder(NODE node){
        if(node == null) return;

        System.out.print(node.data + " ");
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void inOrder(NODE node){
        if(node == null) return;

        this.inOrder(node.left);
        System.out.print(node.data + " ");
        this.inOrder(node.right);
    }

    public void postOrder(NODE node){
        if(node == null) return;

        this.postOrder(node.left);
        this.postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public void levelOrder(NODE node){
        Queue<NODE> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            NODE cur = queue.poll();

            System.out.print(cur.data + " ");
            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
        }
    }
}

public class _02_이진트리구현 {
    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree2 tree = new BinaryTree2(arr);
        tree.preOrder(tree.head);
        System.out.println();
        tree.inOrder(tree.head);
        System.out.println();
        tree.postOrder(tree.head);
        System.out.println();
        tree.levelOrder(tree.head);
    }
}
