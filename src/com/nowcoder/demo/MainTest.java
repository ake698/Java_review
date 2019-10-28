package com.nowcoder.demo;

import java.awt.*;

/**
 * 此时实现DefaultI 接口 可以不用实现 sayHello 方法
 * 但是当实现俩个接口并且存在俩个相同方法名 且被default 修饰的时候 必须重写父类接口
 */
public class MainTest implements DefaultI{
    @Override
    public void sayBye() {
        System.out.println("byebye");
    }


    public static void main(String[] args) throws Exception {
//        new MainTest().sayBye();
//        new MainTest().sayHello();
//        System.out.println(Foo2.a);
        Foo2 foo2 = new Foo2();
//        Foo2 foo21 = new Foo2();
//        System.out.println(foo2.equals(foo21));   //Object 中的equals 方法没有重写 和==一样  比较的是地址
//        System.out.println(foo2.b.equals(foo21.b));
//        foo2.Foo2();  //方法可以和 类同名
//        foo2.throwError(99);
    }
}

/**
 * 子类引用父类的静态字段，只会触发子类的加载、父类的初始化，不会导致子类初始化
 */

class Foo{
    public static int a = 1;
    static {
        System.out.println("foo is");
    }
}

class Foo2 extends Foo{
    static final String b = "abc";
    static {
        System.out.println("foo2 is");
    }

    public void Foo2(){
        System.out.println("foo2");
        System.out.println("--");
    }

    Foo2(){
        System.out.println(super.a);
    }

    public void throwError(int id) throws Exception {
        if(id > 10)throw new Exception("数字太大");
    }
}