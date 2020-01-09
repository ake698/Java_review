package com.nowcoder.DesignPatterns.StrategyPattern;

/**
 * 算法群中的乘法
 */
public class Multiply implements Strategy {
    @Override
    public int doSth(int a, int b) {
        return a*b;
    }
}
