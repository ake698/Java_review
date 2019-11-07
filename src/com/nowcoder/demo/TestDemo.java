package com.nowcoder.demo;

import com.nowcoder.algorithm.MyQueue2;

import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        HashMap<Integer,Integer> myMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(0,1);
        Queue<String> queue = new LinkedList<>();
        List list2 = new LinkedList();

        Set<Character> set = new HashSet<>();
        String a="afadsf";

        for (int i = 0; i < a.length(); i++) {
            System.out.println(a.charAt(i));
        }
        HashMap<String,Integer>map = new HashMap<>();
        map.put("ab",1);
        map.put("ab",1);
        map.put("ab",2);
        System.out.println(map.get("ab"));

        char [][] arrs = new char[3][9];
        arrs[0][0]='s';


    }



}

