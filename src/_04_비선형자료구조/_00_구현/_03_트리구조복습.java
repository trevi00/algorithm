package _04_비선형자료구조._00_구현;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    char data;
    Node left;
    Node right;
    Node parent;

    public Node(char data, Node left, Node right, Node parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class BinaryTree3 {
    Node head;

    public BinaryTree3(char[] arr) {
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i], null, null, null);
        }

        for (int i = 0; i < arr.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if(left < arr.length){
                nodes[i].left = nodes[left];
                nodes[left].parent = nodes[i];
            }

            if(right < arr.length){
                nodes[i].right = nodes[right];
                nodes[right].parent = nodes[i];
            }
        }
        this.head = nodes[0];
    }

    public Node searchNode(char data){
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.head);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.data == data) return cur;

            if(cur.left != null) queue.add(cur.left);

            if(cur.right != null) queue.add(cur.right);
        }
        return null;
    }

    public Integer checkSize(char data){
        Node node = this.searchNode(data);

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        int size = 0;
        while(!queue.isEmpty()){
            Node cur = queue.poll();

            if(cur.left != null) {
                queue.add(cur.left);
                size++;
            }
            if(cur.right != null) {
                queue.add(cur.right);
                size++;
            }
        }
        return size+1;
    }
}

public class _03_트리구조복습 {
    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree3 tree = new BinaryTree3(arr);

        //Root node
        System.out.println("Root : " + tree.head.data);

        // B's children
        Node B = tree.searchNode('B');
        if(B.left != null) System.out.println("B's left child : " + B.left.data);
        if(B.right != null) System.out.println("B's right child : " + B.right.data);

        // F's children
        Node F = tree.searchNode('F');
        if(F.left != null) System.out.println("F's left child : " + F.left.data);
        if(F.right != null) System.out.println("F's right child : " + F.right.data);

        // Leaf node
        System.out.println("Leaf : ");
        for (int i = 0; i < arr.length; i++) {
            Node cur = tree.searchNode((char) ('A' + i));

            if(cur.left == null && cur.right == null)
                System.out.print(cur.data + " ");
        }
        System.out.println();

        // E's Depth
        Node E = tree.searchNode('E');
        Node cur = E;
        int cnt = 0;
        while(cur.parent != null){
            cur = cur.parent;
            cnt++;
        }
        System.out.println("E's depth : " + cnt);

        // Level2 Node
        System.out.println("Level2 Node : ");
        for (int i = 0; i < arr.length; i++) {
            Node target = tree.searchNode((char) ('A' + i));
            cur = target;
            cnt=0;
            while(cur.parent != null){
                cur = cur.parent;
                cnt++;
            }
            if(cnt == 2) System.out.print(target.data + " ");
        }
        System.out.println();

        // Height
        int maxCnt = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            Node target = tree.searchNode((char) ('A' + i));
            cur = target;
            cnt=0;
            while(cur.parent != null){
                cur = cur.parent;
                cnt++;
            }
            if(maxCnt < cnt) maxCnt = cnt;
        }
        System.out.println("Height : " + maxCnt);

        // B's size
        int size = tree.checkSize('B');
        System.out.println("B's size : " + size);

    }
}
