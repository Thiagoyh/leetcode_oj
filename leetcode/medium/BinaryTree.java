package com.lewis.leetcode.medium;

/*
 * 已知一棵二叉树中没有重复节点, 并且给定了这棵树的
 * 中序遍历数组和先序遍历数组, 返回后续遍历数组
 *
 * 比如给定:
 * int[] pre = {1, 2, 4, 5, 3, 6, 7}
 * int[] in = {4, 2, 5, 1, 6, 3, 7}
 * 返回
 * {4, 5, 2, 6, 7, 3, 1}
 */

public class BinaryTree {
    public static int[] getPoseArray(int[] pre, int[] in){
        if(pre == null){
            return null;
        }
        int N = pre.length;
        int[] pos = new int[N];
        set(pre, in, pos, 0, N - 1, 0, N - 1, 0, N - 1);
        return pos;
    }

    public static void set(int[] pre, int[] in, int[] pos,
                           int prei, int prej,
                           int ini, int inj,
                           int posi, int posj){
         if(prei > prej){
             return;
         }
         if(prei == prej){
             pos[posi] = pre[prei];
         }
         pos[posj] = pre[prei];
         int find = ini;
         for(; find <= inj; find++){
             if(in[find] == pre[prei]){
                 break;
             }
         }
         set(pre, in, pos,
              prei + 1, prei + find - ini,
              ini, find - 1
              , posi, posi + find - ini);
         set(pre, in, pos,
                 prei + find - ini + 1, prej,
                 find + 1, inj,
                 posi + find - ini + 1, posj);
    }
}
