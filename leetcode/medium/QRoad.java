package com.lewis.leetcode.medium;

/*
 * 小Q正在给一条长度为n的道路设计路灯安置方案
 * 把道路视为n个方格, 需要照亮的地方yong','表示,
 * 不需要照亮的障碍物格子用'X'表示. 小Q现在要在道路上设置一些路灯,
 * 对于安置在pose位置的路灯, 这盏路灯可以照亮pose - 1, pose,
 * pose + 1, 这三个位置.
 * 小Q希望安置尽量少的路灯照亮所有的'.'区域, 希望你能帮他计算一下最少需要
 * 多少盏路灯
 *
 * 输入描述:
 * 输入的第一行包含一个正整数t(1 <= t <= 1000),表示测试用例数
 * 接下来每两行一个测试数据, 第一行一个正整数n(1 <= n <= 1000),
 * 表示道路的长度. 第二行一个字符串s表示道路的构造, 只包含'.'和'X'
 *
 * 输出描述:
 * 对于每个测试用例, 输出一个正整数表示最少需要多少盏路灯
 */

public class QRoad {

    public static int minLight(String s){
        if(s == null || s.length() == 0){
            return 0;
        }

        char[] str = s.toCharArray();
        int ans = 0;
        int i = 0;
        while(i < str.length){
            if(str[i] == 'X'){
                i++;
            }
            else{
                ++ans;
                if(i + 1 == str.length || str[i + 1] == 'X'){
                   break;
                }
                else{
                    if(str[i + 1] == 'X'){
                        i += 2;
                    }
                    else{
                        i += 3;
                    }
                }
            }
        }
        return ans;
    }

}
