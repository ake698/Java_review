package com.nowcoder.DesignPatterns.StrategyPattern;

/**
 * 算法群中的减法
 */
public class Substract implements Strategy{
    @Override
    public int doSth(int a, int b) {
        return a-b;
    }
}
