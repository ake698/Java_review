package com.nowcoder.AspectJDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspect {
    private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
    public static void main(String[] args) {
        //简单的一个基于注解拦截的aop
        //不能直接用接口的实现类来转换Proxy的实现类
//        IExample example = (IExample) context.getBean("example");
//        example.say();

        UserService userService = (UserService) context.getBean("myservice");
        userService.add(1,"asdf");
    }
}
