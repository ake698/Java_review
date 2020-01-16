package com.nowcoder.DesignPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WXPublic implements Subject{

    private List<Observer> observers = new ArrayList<Observer>();

    /**
     * 微信公众号的发布信息
     */
    private String msg;


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if(index>=0)observers.remove(index);
    }

    /**
     * 通知所有观察者
     */
    @Override
    public void notifyObserver() {
        observers.forEach(observer->{
            observer.update(msg);
        });
    }

    public void setMsg(String msg){
        this.msg = msg;
        notifyObserver();
    }

}
