package com.lewis.leetcode;

public class IsFull {
    public static class Info{
        public int height;
        public int nodes;

        public Info(int h, int n){
            this.height = h;
            this.nodes = n;
        }
    }
    class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Info process(Node x){
        if(x == null){
            return new Info(0, 0);
        }
        Info leftData = process(x.left);
        Info rightData = process(x.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;

        return new Info(height, nodes);
    }

    public static boolean isFull(Node head){
        if(head == null){
            return true;
        }
        Info data = process(head);
        return data.nodes == (1 << data.height - 1);
    }
}
