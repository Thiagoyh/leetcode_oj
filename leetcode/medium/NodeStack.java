package com.lewis.leetcode.medium;

import java.util.HashMap;

public class NodeStack {
     public static class Node{
         public String str;
         public int times;

         public Node(String s, int t){
             str = s;
             times = t;
         }
     }

     public static class TopRecord{
         private HashMap<String, Node> strNodeMap;
         private Node[] heap;
         private HashMap<Node, Integer> nodeIndexMap;
         private int index;

         public void add(int K){
             heap = new Node[K];
             index = 0;
             strNodeMap = new HashMap<>();
             nodeIndexMap = new HashMap<>();
         }

         public void add(String str){
             Node curNode = null;
             int preIndex = -1;
             if(!strNodeMap.containsKey(str)){
                 curNode = new Node(str, 1);
                 strNodeMap.put(str, curNode);
                 nodeIndexMap.put(curNode, -1);
             }
             else {
                 curNode = strNodeMap.get(str);
                 curNode.times++;
                 preIndex = nodeIndexMap.get(curNode);
             }
             if(preIndex == -1){
                 if(index == heap.length){
                     if(heap[0].times < curNode.times){
                         nodeIndexMap.put(heap[0], -1);
                         nodeIndexMap.put(curNode, 0);
                         heap[0] = curNode;
                         heapify(0, index);
                     }
                 }
                 else {
                     nodeIndexMap.put(curNode, index);
                     heap[index] = curNode;
                     heapInsert(index++);
                 }
             }
             else{
                 heapify(preIndex, index);
             }
         }
         public void heapify(int index, int heapSize){
              int l = index * 2 + 1;
              int r = index * 2 + 2;
              int smallest = index;
              while(1 < heapSize){
                  if(heap[l].times < heap[index].times){
                      smallest = l;
                  }
                  if(r < heapSize && heap[r].times < heap[smallest].times){
                      smallest = r;
                  }
                  if(smallest != index){
                      swap(smallest, index);
                  } else {
                      break;
                  }
                  index = smallest;
                  l = index * 2 + 1;
                  r = index * 2 + 2;
              }
         }
         public void heapInsert(int index){
                while (index != 0){
                    int parent = (index - 1) / 2;
                    if(heap[index].times < heap[parent].times){
                           swap(heap[index], heap[parent]);
                           index = parent;
                    }
                    else{
                        break;
                    }
                }
         }
         public void swap(Node a, Node b){
             Node tmp = a;
             a = b;
             b = tmp;
         }
         public void swap(int a, int b){
             int tmp = a;
             a = b;
             b = tmp;
         }
     }
}
