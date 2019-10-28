package com.nowcoder.demo;



import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        String s = "hello world abc";
//        char []c = s.toCharArray();
//        rerverse(c);

//排序组合
        String [] a = {"a","b","c","d"};
        int []hasSelect = {};
        combime(a,0);
        for (Object o : set) {
            System.out.println(o);
        }


    }

    public static String statckToString(Stack s){
        StringBuffer sb = new StringBuffer();
//        System.out.println(s.toString());
        Iterator it = s.iterator();
        while (it.hasNext()){
            String a = (String)it.next();
            sb.append(a);
        }
        return sb.toString();
    }

    public static void rerverse(char[] str){
        String [] p = new String(str).split(" ");
        String [] o = new String[p.length];
        int index=0;
        for(int i=p.length-1;i>0;i--){
            o[index] = p[i];
            index++;
        }
        for (String s : o) {
            System.out.println(s);
        }
    }

    public static Boolean selectFlag(int i){
        for (Integer integer : hasSelect) {
            if(integer==i)return true;
        }
        return false;
    }


    //组合排序不重复
    private static Stack<String> stack = new Stack<String>();
    private static Stack<Integer> hasSelect = new Stack<Integer>();
    private static Set<String> set = new HashSet<String>();
    public static void combime(String []arr,int index){
        if(index == arr.length){
            set.add(statckToString(stack));
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(selectFlag(i))continue;
            stack.add(arr[i]);
            hasSelect.add(i);
            combime(arr,index+1);
            stack.pop();
            hasSelect.pop();
        }

    }

}
