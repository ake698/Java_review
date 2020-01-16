package com.nowcoder.algorithm;

public class DiGui {

    protected String a = "a";

    public static void main(String[] args) {
        test(0);
    }
    public static void test(int i){
        if(i<10){   //i==10 时 无法运行 继续执行test(++1) 下的代码  此时i=9  又++i  所以 输出javajava10
            System.out.println("helloworld"+i);
            test(++i);
            System.out.println("javajava"+i);
        }
    }

}
