package com.nowcoder.DesignPatterns.observer;

public interface Subject {

    /**
     * 注册一个观察者
     * @param observer
     */
    public void registerObserver(Observer observer);

    /**
     * 删除一个观察者
     * @param observer
     */
    public void removeObserver(Observer observer);

    /**
     * 通知所有观察者
     */
    public void notifyObserver();
}
