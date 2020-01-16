package com.nowcoder.demo;

public class IntegerTest {
    public static void main(String[] args) {
        Integer i01 = 59;
        int i02 = 59;
        Integer i03 = Integer.valueOf(59);
        Integer i04 = new Integer(59);
        System.out.println(i01==i02);  //t
        System.out.println(i03==i01); //t
        System.out.println(i04==i03); //f
    }
}
