package com.lewis.leetcode.medium;

/*
 * 双向链表节点结构和二叉树节点结构是一样的, 如果你把last认为是left,
 * next人为是right的话
 *
 * 给定一个搜索二叉树的头节点head, 请转化一条有序的双向链表, 并返回链表的头节点
 */

public class TreeToDoublyList {
    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(){}

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static class Info{
            public Node start;
            public Node end;
            public Info(Node start, Node end){
                this.start = start;
                this.end = end;
            }
        }

        public static Info process(Node x){
            if(x == null){
                return new Info(null, null);
            }
            Info leftHeadEnd = process(x.left);
            Info rightHeadEnd = process(x.right);

            if(leftHeadEnd.end != null){
                leftHeadEnd.end.right = x;
            }
            x.left = leftHeadEnd.end;
            x.right = rightHeadEnd.start;
            if(rightHeadEnd.start != null){
                rightHeadEnd.start.left = x;
            }
            return new Info(leftHeadEnd.start != null ? leftHeadEnd.start : x,
                    rightHeadEnd.end != null ? rightHeadEnd.end : x);
        }
    }
}
