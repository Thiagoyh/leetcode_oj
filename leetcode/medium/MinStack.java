package com.lewis.leetcode.medium;

/*
 * 实现一个特殊的栈, 在实现栈的基本功能的基础上, 再实现返回栈中最小元素的操作
 *
 * 要求: 1. pop push getMin的时间复杂度都是O(1), 设计的栈类型可以使用现成的
 * 栈结构
 */

import java.util.Stack;

public class MinStack{

    public static class MinStackStruct{
        public Stack<Integer> data;
        public Stack<Integer> min;

        public MinStackStruct(){
            data = new Stack<>();
            min = new Stack<>();
        }

        void pop(){
            if(data.isEmpty()){
                return;
            }
            else{
                data.pop();
                min.pop();
            }
        }

        void push(int a){
            if(data.isEmpty()){
                data.push(a);
                min.push(a);
            }

            else{
                data.push(a);
                if(a < min.peek()){
                    min.push(a);
                }
                else {
                    min.push(min.peek());
                }
            }
        }

        int getMin(){
            if(min.isEmpty()){
                return -1;
            }
            else {
                return min.peek();
            }
        }

    }

}