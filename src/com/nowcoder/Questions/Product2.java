package com.nowcoder.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。
 *
 * 空格分隔的两个字符串，代表输入的两个大整数
 *
 * 输入的乘积，用字符串表示
 *
 */
public class Product2 {

    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String numbers = bf.readLine();
        String numbers = "696364 123658";
        String [] arrs = numbers.split(" ");
        Product2Func(arrs[0],arrs[1]);

    }

    public static void Product2Func(String s1,String s2){

        int [] arr1 = new int[s1.length()];
        int [] arr2 = new int[s2.length()];
        int [] result = new int[s1.length()+s2.length()];
        StringBuffer sb = new StringBuffer();
        for (int i = s1.length()-1; i >=0; i--) {
            arr1[i] = s1.charAt(s1.length()-1-i)-'0';
        }
        for (int i = s2.length()-1; i >=0; i--) {
            arr2[i] = s2.charAt(s2.length()-1-i)-'0';
        }


        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                result[i+j] += arr1[i]*arr2[j];
            }
        }

        for (int i = 0; i < result.length; i++) {
            int temp = result[i] / 10;  //往上晋的数
            int data = result[i] % 10;  //留下来的数
            if(temp>=1){
                result[i+1] += temp;
            }
            result[i] = data;
        }
        for (int i = result.length-1; i >= 0 ; i--) {
            if(i==result.length-1 && result[i]==0)continue;
            sb.append(result[i]);
        }
        System.out.println(sb.toString());
    }

}
