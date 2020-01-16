package com.nowcoder.demo;

import com.nowcoder.algorithm.DiGui;

import java.lang.reflect.Array;
import java.util.*;

/**
 * HashMap中，使用 get(key)==null可以 判断这个Hashmap是否包含这个key
 * HashMap hashMap = new HashMap();
 * System.out.println(hashMap.get("g"));   null
 *
 * final 类不能再被声明为abastract类
 *
 * 声明为public类型的类名必须与文件名相同，默认权限的可以不同
 * 并且内部类的类名一般与文件名不同
 *·
 * Java中静态变量只能在类主体中定义，不能在方法中定义。
 * 静态变量属于类所有而不属于方法。
 */

public class demo1 {

    int a = 10;

    //取模运算，结果的符号和被除数y符号一致
    public static void  test1(){
        int x = -3;
        int y = 10;
        System.out.println(y%x);
    }



    public static void Intest(){
        Integer f1=100,f2=100,f3=127,f4=127,f5=128,f6=128;
        System.out.println(f1==f2);
        System.out.println(f3==f4);
        System.out.println(f5==f6);
    }


    public static boolean demo6_equals(Object a,Object b){
        if (!(a instanceof String && b instanceof String)) {
            return false;
        }
        if(((String) a).length()!=((String) b).length()){
            return false;
        }
        int index=0;
        char [] ac = ((String)a).toCharArray();
        char [] bc = ((String)b).toCharArray();
        while (((String) a).length()-1>=index){
            if(ac[index]!=bc[index]){
                return false;
            }
            index++;
        }
        return true;
    }
    public static void main(String[] args) {
        test1();

        S s= new S();
        s.a();
    }
}

class aa extends DiGui{
    String a = super.a;
}

class P{
    public static int number=10;
    static {
        System.out.println("P is init");
    }

    public void a(){
        b();  //当运行S.a（） 方法时候 此时是调用子类中的b方法
    }
    public void b(){
        System.out.println("Base b method");
    }
}

class S extends P{
    static {
        System.out.println("S is init");
    }
    public void a(){
        super.a();
    }
    public void b(){
        System.out.println("Child b");
    }

}
