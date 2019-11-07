package com.nowcoder.Questions;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

     输入: "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     示例 2:

     输入: "bbbbb"
     输出: 1
     解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     示例 3:

     输入: "pwwkew"
     输出: 3
     解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
          请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 */
public class checkMaxString {

    public static void main(String[] args) {
        String s= "abba";
        System.out.println("ab".substring(0,1));
        Map<Character,Integer> map = new HashMap<>();
        System.out.println(map.get("aa"));
        int max=0;
        for (int l = 0,r = 0; r < s.length(); r++) {
            if(map.containsKey(s.charAt(r))){
                l = Math.max(map.get(s.charAt(r)),l);
            }
            max = Math.max(max,r-l+1);
            map.put(s.charAt(r),r+1);
        }
        System.out.println(max);
    }

}
