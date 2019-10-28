package com.nowcoder.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，
 * 要求时间复杂度：O(n)，空间复杂度：O(1)
 *
 * 输入共2行，第一行包括一个整数n，表示数组长度
   第二行为n个以空格隔开的整数，分别为A1,A2, … ,An

   输出 满足条件的最大乘积


 整体思路：
   定义3个最大值，定义俩个最小值 将数组中的5个值对应填入  最后返回3最大值相乘 和 最大值和俩最小值相乘 中的最大值
 */
public class Product {


    public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(ir);

        int number =Integer.parseInt(bf.readLine());
        String arrStr = bf.readLine();
        String [] arrs = arrStr.split(" ");
        int [] nums = new int[arrs.length];
        for (int i = 0; i < arrs.length; i++) {
            nums[i] = Integer.parseInt(arrs[i]);
        }
        System.out.println(maxProduct(nums));
    }

    public static long maxProduct(int arrs []){
        int max1= Integer.MIN_VALUE,max2= Integer.MIN_VALUE,max3 = Integer.MIN_VALUE;
        int min1= Integer.MAX_VALUE,min2 = Integer.MAX_VALUE;
        for (int i : arrs) {

            if(i > max1){
                max3 = max2;
                max2 = max1;
                max1 = i;
            }else if(i > max2){
                max3 = max2;
                max2 = i;
            }else if(i>max3){
                max3 = i;
            }

            if(i < min1){
                min2 = min1;
                min1 = i;
            }else if(i<min2){
                min2 = i;
            }
        }
        return Math.max((long)max1*max2*max3,(long)max1*min1*min2);
    }

}
