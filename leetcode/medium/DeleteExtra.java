package com.lewis.leetcode.medium;

/*
 * 给定一个全是小写字母的字符串str, 删除多余字符, 使得每种
 * 字符都只保留一个, 并让最终结果字符串的字典序最小
 */

public class DeleteExtra {
    public static String deleteExtra(String s){
        if(s == null || s.equals("")){
            return "";
        }
        int[] map = new int[256];
        for(int i = 0; i < 256; i++){
            map[i] = -1;
        }
        char[] str = s.toCharArray();
        char[] res_char = new char[s.length()];
        for(int i = 0; i < str.length; i++){
            if(map[str[i]] == -1){
                map[str[i]] = i;
            }
            else{
                int index = map[str[i]];
                while(index != i){
                    if(str[index + 1] != 'A'){
                        if(str[index + 1] - str[map[str[i]]] < 0){
                            str[map[str[i]]] = 'A';
                            map[str[i]] = i;
                        }
                        else {
                            str[i] = 'A';
                        }
                        break;
                    }
                    index++;
                }
            }
        }
        int index = 0;
        for(int i = 0; i < str.length; i++){
            if(str[i] != 'A'){
                res_char[index++] = str[i];
            }
        }
        String res = String.copyValueOf(res_char, 0, index);
        return  res;
    }

    public static void main(String[] args) {
        String s = "acbc";
        System.out.println(s);
        String s1 = deleteExtra(s);
        System.out.println(s1);
    }
}
