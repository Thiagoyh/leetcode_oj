package com.lewis.leetcode.important;

/*
 * 给你一个字符串类型的数组, 譬如:
 * String[] arr = { "b\\cast", "d\\", "a\\d\\e", "a\\b\\c" }
 * 你把这些路径中蕴含的目录结构画出来, 子目录直接列在父目录下, 并比父目录
 * 向右前进两格, 就像这样:
 * a
 *   b
 *     c
 *   d
 *     e
 * b
 *   cast
 * d
 */

import java.util.TreeMap;

public class TrieTree {
    public static class Node{
        public String name;
        public TreeMap<String, Node> nextMap;

        public Node(String name){
            this.name = name;
            nextMap = new TreeMap<>();
        }
    }

    public static Node generateFolderTree(String[] folderPaths){
        Node head = new Node("");
        for(String foldPath : folderPaths){
            String[] paths = foldPath.split("\\\\");
            Node cur = head;
            for(int i = 0; i <paths.length; ++i){
                if(!cur.nextMap.containsKey((paths[i]))){
                    cur.nextMap.put(paths[i], new Node(paths[i]));
                }
                cur = cur.nextMap.get(paths[i]);
            }
        }
        return head;
    }

    public static void main(String[] args){

    }
}
