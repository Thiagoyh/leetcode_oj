package com.lewis.leetcode;

public class TryTrieTree {
    // 根节点的pass值表示加入了多少字符串，根节点的end表示加入了多少个空串
    public static class TrieNode{
        public int pass;
        public int end;
        public TrieNode[] nexts;
        // 如果字符种类太多, 用哈希表来表示
        // HashMap<Char, Node> nexts

        public TrieNode(){
            pass = 0;
            end = 0;

            nexts = new TrieNode[26];
        }
    }

    public static class Trie{
        public TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            if(word == null){
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }
    }
}
