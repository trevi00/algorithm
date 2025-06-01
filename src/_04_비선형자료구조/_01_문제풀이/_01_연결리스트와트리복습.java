package _04_비선형자료구조._01_문제풀이;

// 연결리스트를 이용한 이진 트리 구성, 순회

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree{
    Node head;

    public BinaryTree() {
    }

    public BinaryTree(char[] arr) {
        Node[] nodes = new Node[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int left = 2*i+1;
            int right = 2*i+2;

            if(left < arr.length){
                nodes[i].left = nodes[left];
            }
            if(right < arr.length){
                nodes[i].right = nodes[right];
            }
        }
        this.head = nodes[0];
    }

    public void preOrder(Node node){
        if(node == null) return;

        System.out.print(node.data + " ");
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void inOrder(Node node){
        if(node == null) return;

        this.inOrder(node.left);
        System.out.print(node.data + " ");
        this.inOrder(node.right);
    }

    public void postOrder(Node node){
        if(node == null) return;

        this.postOrder(node.left);
        this.postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            System.out.print(cur.data + " ");
            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
        }
    }
}

public class _01_연결리스트와트리복습 {
    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree tree = new BinaryTree(arr);

        tree.preOrder(tree.head);

        System.out.println();

        tree.inOrder(tree.head);

        System.out.println();

        tree.postOrder(tree.head);

        System.out.println();

        tree.levelOrder(tree.head);
    }
}
