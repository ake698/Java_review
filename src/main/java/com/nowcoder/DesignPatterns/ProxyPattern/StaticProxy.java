package com.nowcoder.DesignPatterns.ProxyPattern;

/**
 * AOP 静态代理
 * 优点：可以在不修改目标对象的前提下扩展目标对象的功能。
 *
 * 缺点：
 * 冗余。由于代理对象要实现与目标对象一致的接口，会产生过多的代理类。
 * 不易维护。一旦接口增加方法，目标对象与代理对象都要进行修改。
 */
public class StaticProxy implements IUserDao {

    private IUserDao iUserDao;
    public StaticProxy(IUserDao iUserDao){
        this.iUserDao = iUserDao;
    }
    @Override
    public void save() {
        System.out.println("---------------开启事务-------------------");
        iUserDao.save();
        System.out.println("------------------提交事务--------------------");
    }

    public static void main(String[] args) {
        //目标对象
        IUserDao target = new UserDao();
        //静态代理
        StaticProxy proxy = new StaticProxy(target);
        proxy.save();
    }
}


interface IUserDao{
    public void save();
}

class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("----------------保存数据-----------------");
    }
}