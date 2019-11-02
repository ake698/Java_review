package com.nowcoder.Questions;

import java.util.HashMap;
import java.util.Stack;

/**
 * 判断括号字符串是否有效    （） 有效  （[]） 有效   ({[(})) 无效
 */

public class Brackets {


    public static void main(String[] args) {
//        String str = "([{}])";
//        String str = "([{()}[]])";
        String str = "([[{]}])";
        System.out.println(solution(str));
        System.out.println(solution2(str));
    }

    //根据栈和 map实现
    public static boolean solution(String s){
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character>hashMap = new HashMap<Character, Character>();
        hashMap.put(')','(');
        hashMap.put(']','[');
        hashMap.put('}','{');
        char [] c =s.toCharArray();
        for (char c1 : c) {
            if(hashMap.get(c1)==null){  //如果找不到对应的key 就说明c1为左边括号  压栈
                stack.push(c1);
            }else{
                if(hashMap.get(c1)!=stack.pop())return false;  //判断是否能消除对应的括号
            }
        }
        return true;
    }


    //根据消除相邻括号对实现  但是时间复杂度不好计算
    public static boolean solution2(String s){
        int length=0;
//        do {
//            length = s.length();
//            s = s.replace("[]","").replace("{}","").replace("()","");
//        }while (s.length()!=length);
        while (s.length()!=length){
            length = s.length();
            s = s.replace("[]","").replace("{}","").replace("()","");
        }
        return s.length()==0;
    }
}
