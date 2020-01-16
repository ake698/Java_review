package com.nowcoder.DesignPatterns.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 静态代理与动态代理的区别主要在：
 *
 * 静态代理在编译时就已经实现，编译完成后代理类是一个实际的class文件
 * 动态代理是在运行时动态生成的，即编译完成后没有实际的class文件，而是在运行时动态生成类字节码，并加载到JVM中
 * 特点：
 * 动态代理对象不需要实现接口，但是要求目标对象必须实现接口，否则不能使用动态代理。
 */
public class DynamicProxy {
    //维护一个目标对象
    private Object target;

    public DynamicProxy(Object target){
        this.target = target;
    }

    // 为目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务");

                        // 执行目标对象方法
                        Object returnValue = method.invoke(target, args);

                        System.out.println("提交事务");
                        return returnValue;
                    }
                });
    }

    public static void main(String[] args) {
        IUserDao2 userDao2 = new UserDao2();
        System.out.println(userDao2.getClass());
        IUserDao2 proxy = (IUserDao2) new DynamicProxy(userDao2).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }
}


interface IUserDao2{
    void save();
}
class UserDao2 implements IUserDao2{
    @Override
    public void save() {
        System.out.println("-----------数据保存-----------------");
    }
}
