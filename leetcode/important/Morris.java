package com.lewis.leetcode.important;

// 二叉树里边最炫酷的东西Morris遍历

/*
 * 一种二叉树遍历方式，并且时间复杂度O(n), 额外空间复杂度O(1)
 *
 */

public class Morris {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }

    public static void morris(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    public static void morrisPos(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
        System.out.println();
    }

    public static void printEdge(Node x){

    }

    // 判断是不是搜索二叉树
    public static boolean isBST(Node head){
        if(head == null){
            return true;
        }
        Node cur = head;
        Node mostRight = null;
        int preValue = Integer.MIN_VALUE;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                }
            }
            if(cur.value <= preValue){
                return false;
            }
            preValue = cur.value;
            cur = cur.right;
        }
        return true;
    }
}
