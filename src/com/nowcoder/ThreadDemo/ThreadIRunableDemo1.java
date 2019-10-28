package com.nowcoder.ThreadDemo;

import java.util.ArrayList;
import java.util.List;

public class ThreadIRunableDemo1 implements Runnable {
//    private int count=20;
    private String name;
    ThreadIRunableDemo1(String name){
        this.name = name;
    }
    @Override
    public /*synchronized*/ void run() {
//        count--;
//        System.out.println(Thread.currentThread().getName()+"--"+count);
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        List<Thread> list = new ArrayList<Thread>();
        Thread t;
        for (int i = 0; i <20 ; i++) {
             t= new Thread(new ThreadIRunableDemo1("thread"+i),"thread"+i);
            list.add(t);
            t.start();
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                list.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(".............Done");
    }
}
