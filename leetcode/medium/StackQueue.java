package com.lewis.leetcode.medium;

/*
 * 使用栈结构实现队列结构
 * push栈东西一次倒完，pop栈如果有东西一定不要往里倒数据
 * 使用队列结构实现栈结构
 * 留下最后一个数, 其余的都给另一个队列
 */

import java.util.Stack;

public class StackQueue {
      public static class TwoStacksQueue{
          private Stack<Integer> stackPush;
          private Stack<Integer> stackPop;

          public TwoStacksQueue(){
              stackPop = new Stack<>();
              stackPush = new Stack<>();
          }

          public void push(int pushInt){
              stackPush.push(pushInt);
              pushAll();
          }

          public int poll(){
              if(stackPop.empty() && stackPush.empty()){
                  throw new RuntimeException("Queue is empty");
              }
              pushAll();
              return stackPop.pop();
          }

          public int peek(){
              if(stackPop.empty() && stackPush.empty()){
                  throw new RuntimeException("Queue is empty");
              }
              pushAll();
              return stackPop.peek();
          }

          private void pushAll(){
              if(stackPop.isEmpty()){
                  while(!stackPush.isEmpty()){
                      stackPop.push(stackPush.pop());
                  }
              }
          }


      }
}
