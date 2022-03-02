package com.lewis.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {
    // 从head出发到所有点的最小距离
     public static HashMap<Node, Integer> dijkstra(Node head){
         HashMap<Node, Integer> distanceMap = new HashMap<>();
         distanceMap.put(head, 0);

         // 记录已经选过的Node
         HashSet<Node> selectedNodes = new HashSet<>();
         // 求distanceMap中
         Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
         while(minNode != null){
             int distance = distanceMap.get(minNode);
             for(Edge edge : minNode.edges){
                 Node toNode = edge.to;
                 if(!distanceMap.containsKey(toNode)){
                     distanceMap.put(toNode, distance + edge.weight);
                 }
                 distanceMap.put(edge.to, Math.min(distanceMap.get(toNode),
                         distance + edge.weight));
             }
             selectedNodes.add(minNode);
             minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
         }
         return distanceMap;

     }

     public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap,
                                                        HashSet<Node> touchedNodes){
          Node minNode = null;
          int minDistance = Integer.MAX_VALUE;
          for(Map.Entry<Node, Integer> entry : distanceMap.entrySet()){
              Node node = entry.getKey();
              int distance = entry.getValue();
              if(!touchedNodes.contains(node) && distance < minDistance){
                  minNode = node;
                  minDistance = distance;
              }
          }
          return minNode;
     }

     public static class NodeHeap{
         private Node[] nodes;
         private HashMap<Node, Integer> heapIndexMap;
         private HashMap<Node, Integer> distanceMap;
         private int size;

         public void addOrUpdateOrIgnore(Node node, int distance){

         }
         public boolean isEmpty(){

             return true;
         }
         public NodeRecord pop(){
             return new NodeRecord(new Node(1), 1);
         }
         private boolean isEntered(Node node){
             return heapIndexMap.containsKey(node);
         }
         private boolean inHeap(Node node){
             return isEntered(node) && heapIndexMap.get(node) != -1;
         }
         private void swap(int index1, int index2){
             heapIndexMap.put(nodes[index1], index2);
             heapIndexMap.put(nodes[index2], index1);

             Node tmp = nodes[index1];
             nodes[index1] = nodes[index2];
             nodes[index2] = tmp;
         }
     }
     public static class NodeRecord{
         public Node node;
         public int distance;

         public NodeRecord(Node node, int distance){
             this.node = node;
             this.distance = distance;
         }
     }

     public static HashMap<Node, Integer> dijkstra2(Node head){
         NodeHeap nodeHeap = new NodeHeap();
         nodeHeap.addOrUpdateOrIgnore(head, 0);
         HashMap<Node, Integer> result = new HashMap<>();
         while(!nodeHeap.isEmpty()){
             NodeRecord record = nodeHeap.pop();
             Node cur = record.node;
             int distance = record.distance;
             for(Edge edge : cur.edges){
                 nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
             }
             result.put(cur, distance);
         }
         return result;
     }
}
