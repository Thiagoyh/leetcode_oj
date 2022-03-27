package com.lewis.leetcode.medium;

/*
 * 请编写一个程序, 对一个栈里的整形数据, 按照升序进行排序(即排序前,
 * 栈里的数据是无序的, 排序后最大的元素位于栈顶,要求最多只能使用一个额外的栈存放临时数据,
 * 但不得将元素复制到其他数据结构中
 */

import java.util.Stack;

public class OrderedStack {
    public static Stack<Integer> order(Stack<Integer> stack){
        if(stack.isEmpty() || stack.size() == 1){
            return stack;
        }
        Stack<Integer> stack1 = new Stack<>();
        while(!stack.isEmpty()){
            int top = stack.pop();
            if(stack1.isEmpty()){
                stack1.push(top);
                continue;
            }
            while (!stack1.isEmpty()){
                if(top <= stack1.peek()){
                    stack1.push(top);
                    break;
                }
                else {
                    stack.push(stack1.pop());
                }
            }
            if(stack1.isEmpty()){
                stack1.push(top);
            }
        }
        return stack1;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        Stack<Integer> stack1 = order(stack);
        while (!stack1.isEmpty()){
            System.out.println(stack1.pop());
        }
    }
}
