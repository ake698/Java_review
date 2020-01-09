package com.nowcoder.DesignPatterns.StrategyPattern;

/**
 * 算法群中的加法
 */
public class Add implements Strategy {
    @Override
    public int doSth(int a, int b) {
        return a+b;
    }
}
