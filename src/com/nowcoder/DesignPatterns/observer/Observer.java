package com.nowcoder.DesignPatterns.observer;

/**
 * 观察者设计模式
 * 所有观察者都需要实现此接口
 */
public interface Observer {

    public void update(String msg);

}
