package com.nowcoder.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 有两个字符串（可能包含空格）,请找出其中最长的公共连续子串,输出其长度。

 输入描述:
 给定两行字符串

 长度在1000以内
 输出描述:
 输出这两个字符串的最长公共连续子串的长度
 */
public class LCS {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char [] c1 = bf.readLine().toCharArray();
        char [] c2 = bf.readLine().toCharArray();
        soultion(c1,c2);
    }

    public static void soultion(char [] c1,char [] c2){
        int max = 0;
        int index = 0;
        int [][] dep = new int[c1.length][c2.length];
//        System.out.println(dep[0][0]);
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                if(c1[i]==c2[j]){
                    if(i==0||j==0){
                        dep[i][j] = 1;
                    }else{
                        dep[i][j] = dep[i-1][j-1] + 1;
                    }
                }
                if(dep[i][j]>max){
                    index = i; //为输出相同字符串做记录 记录最大的索引座标
                }
                max = Math.max(dep[i][j],max);

            }
        }
        System.out.println(max);
        System.out.println(index);
        for (int i = 0; i<max; i++) {  //输出最长公共穿
            System.out.print(c1[index-max+i+1]);
        }
    }

}
