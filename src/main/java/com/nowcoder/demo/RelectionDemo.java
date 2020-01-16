package com.nowcoder.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RelectionDemo {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        demo1 d = new demo1();
        Class cl = d.getClass();
        // /getMethod方法第一个参数指定一个需要调用的方法名称
        // 方法的参数类型列表，是参数类型！如无参数可以指定null
        // /该方法返回一个方法对象
        Method intest = cl.getMethod("Intest",null);
        Method equals = cl.getMethod("demo6_equals",new Class[]{Object.class,Object.class});
        intest.invoke(d);
        Object[] a = {"3","6"};
        boolean invoke = (boolean) equals.invoke(d, a);
        System.out.println(invoke);
    }

    public Object getProperty(Object owner,String filedName) throws NoSuchFieldException, IllegalAccessException {
        Class ownerClass = owner.getClass();

        Field field = ownerClass.getField(filedName);

        Object property = field.get(owner);

        return property;
    }

}
