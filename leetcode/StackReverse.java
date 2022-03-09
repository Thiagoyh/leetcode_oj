package com.lewis.leetcode;


import java.util.Stack;

// 给你一个stack, 请你逆序这个站，不能申请额外的数据结构，只能使用递归函数
public class StackReverse {
    public static int f(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }
        else{
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }
}
