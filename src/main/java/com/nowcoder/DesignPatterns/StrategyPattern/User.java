package com.nowcoder.DesignPatterns.StrategyPattern;

/**
 * 定义一个使用者
 */
public class User {

    private Strategy strategy;

    public User(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int a,int b){
        return strategy.doSth(a,b);
    }

    public static void main(String[] args) {
        User user = new User(new Add());
        int result = user.executeStrategy(1,4);
        System.out.println(result);

        user = new User(new Substract());
        result = user.executeStrategy(5,6);
        System.out.println(result);

        user = new User(new Multiply());
        result = user.executeStrategy(3,7);
        System.out.println(result);
    }

}
