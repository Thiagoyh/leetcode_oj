package com.lewis.leetcode.medium;

/*
 * 求完全二叉树节点的个数
 */

/*
 * step1: 求完全二叉树的深度, 一直往左走, 走到不能最后就是深度
 */

import java.util.LinkedList;
import java.util.Queue;

public class FullBinaryTree {

    public  static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(){
            this.left = null;
            this.right = null;
        }
        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // 数据是分层给的
    public static Node createTree(int[] arr){
        if(arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node cur = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        int index = 1;
        while(!queue.isEmpty() && index != arr.length){
            cur = queue.poll();
            if(index < arr.length){
                Node leftNode = new Node(arr[index]);
                cur.left = leftNode;
                queue.add(leftNode);
            }
            index++;
            if(index < arr.length){
                Node rightNode = new Node(arr[index]);
                cur.right = rightNode;
                queue.add(rightNode);
            }
            index++;
        }
        return head;
    }

    public static int depth(Node head){
         int depth = 0;
         while(head != null){
             ++depth;
             head = head.left;
         }
         return depth;
    }

    public static int process(Node head){
        if(head == null){
            return 0;
        }
        if(head.left == null){
            return 1;
        }
        if(head.right == null){
            return 2;
        }
        Node leftNode = head.left;
        Node rightNode = head.right;

        if(depth(rightNode) == depth(head) - 1){
            return  (1 << depth(rightNode)) + process(head.right);
        }
        else{
            return process(head.left) + (1 << depth(rightNode));
        }
    }

    public static int number(Node head){
        return process(head);
    }

    public static void main(String[] args) {
        int[] arr = new int[13];
        Node head = createTree(arr);
        System.out.println(number(head));
    }
}
