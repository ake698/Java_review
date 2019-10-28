package com.nowcoder.demo;

import java.nio.CharBuffer;
import java.util.*;

public class HashMapDemo {

    private static ArrayList<Character> tmpArr = new ArrayList<>();
    private static StringBuffer sb = new StringBuffer("");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        char com [] = a.toCharArray();
        int k = com.length;
        System.out.println("组合结果：");
        combine(0 ,k ,com);
    }

    public static void combine(int index,int k,char []arr) {
        if(k == 1){
            for (int i = index; i < arr.length; i++) {
                tmpArr.add(arr[i]);
                System.out.print(tmpArr.toString() + ",");
                tmpArr.remove((Object)arr[i]);
            }
        }else if(k > 1){
            for (int i = index; i <= arr.length - k; i++) {
                tmpArr.add(arr[i]); //tmpArr都是临时性存储一下
                combine(i + 1,k - 1, arr); //索引右移，内部循环，自然排除已经选择的元素
                tmpArr.remove((Object)arr[i]); //tmpArr因为是临时存储的，上一个组合找出后就该释放空间，存储下一个元素继续拼接组合了
            }
        }else{
            return ;
        }

    }
}

