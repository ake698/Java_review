package com.nowcoder.demo;

public interface DefaultI {
    default void sayHello(){    //存在default  实现改接口的类 可不用实现sayHello 方法
        System.out.println("hello by DefaultI");
    }
    public void sayBye();
}
