package com.lewis.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LinkNodeBack {
    public static class Node{
        public int value;
        public Node next;

        public Node(int data){
            this.value = data;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i != list.size(); ++i){
            st.add(list.get(i));
        }
        int index = 0;
        while (!st.isEmpty() && index < list.size()){
            if(list.get(index) != st.pop())
            {
                System.out.println("llllll");
                break;
            }
            ++index;
        }
        if(index == list.size())
            System.out.println("Yes!");
        else
            System.out.println("No!");
    }

    // n / 2 extra space
    public static boolean isPalindrome2(Node head){
        if (head == null || head.next == null)
            return true;
        Node right = head.next;
        Node cur = head;
        while(cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while(right != null){
            stack.push(right);
            right = right.next;
        }
        while(!stack.isEmpty()){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /*
     * 不使用其他数据结构
     */
    public static boolean isPalindrome3(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while(n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while (n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null){
            if(n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;

        while (n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
