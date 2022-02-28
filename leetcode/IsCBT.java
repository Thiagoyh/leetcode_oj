package com.lewis.leetcode;

import java.util.LinkedList;

public class IsCBT {
    public class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }
    public static boolean isCBT(Node head){
        if(head == null)
            return true;
        LinkedList<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            if( (leaf && (l != null || r != null)) ||
                    (l == null && r != null)){
                return false;
            }
            if(l != null){
                queue.add(l);
            }
            if(r != null){
                queue.add(r);
            }
            if(l == null || r == null){
                leaf = true;
            }
        }
        return true;
    }
}
