package com.lewis.leetcode.advanced;

/*
 * 给定一个环形单链表, 从1开始报数, 报到m时候把当前节点杀死
 * 继续从杀死的节点的下一个节点报数
 */

// 新老节点转换公式 old = (new - 1 + s) % i + 1    s = (m - 1) % i + 1
// old = (new + m - 1) % i + 1

public class CircleLinkedNode {
    public static class Node{
        public int value;
        public Node next;
    }

    public static int getLive(int i, int m){
        if(i == 1){
            return 1;
        }
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }

    public static Node liveNode(Node head, int N, int M){
        if(head == null || head.next == head || M < 1){
            return head;
        }
        Node cur = head.next;
        int tmp = 1;
        while (cur != head){
            tmp++;
            cur = cur.next;
        }
        tmp = getLive(tmp, M);
        while (--tmp != 0){
            head = head.next;
        }
        return head;
    }
}
