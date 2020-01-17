package com.nowcoder.AspectJDemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

/**
 * 定义拦截方式  此处提供5种方法
 */
@Service
@Aspect
public class OperateService {

    @Pointcut("execution(* com.nowcoder.AspectJDemo.UserService.add(..))")
    public void pointCut(){
        System.out.println("this is ponitCut");
    }

    @Before(value="execution(* com.nowcoder.AspectJDemo.UserService.add(..))&&args(id,name)",argNames = "id,name")
    public void beforeAdd(Integer id,String name){
        System.out.println("插入前..." + "args.id = " + id + ";name=" + name);
    }

    @After("execution(* com.nowcoder.AspectJDemo.UserService.add(..))")
    public void afterAdd(){
        System.out.println("插入成功.....");
    }

    @AfterReturning(pointcut = "pointCut()",returning = "object")
    public void afterAdd2(JoinPoint joinPoint,Object object){
        System.out.println("插入成功.....result is:"+object);
    }

    //around其实是代理了我们的方法，around没有return，拿到的自然是null，如果给around一个返回值，那么afterReturning也是能拿到值的。
    @Around(value="execution(* com.nowcoder.AspectJDemo.UserService.add(..))&&args(id,name)",argNames = "id,name")
    public String aroundOperate(ProceedingJoinPoint point,Integer id,String name){
        System.out.println("around1 id =" + id + " name=" + name);
        String str = "";
        try {
            str = (String) point.proceed();
        } catch (Throwable e) {
            System.out.println("报错了");
        }
        System.out.println("around2");
//        return "这是around 返回的";
        return str;
    }


}
