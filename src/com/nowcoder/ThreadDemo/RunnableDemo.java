package com.nowcoder.ThreadDemo;

public class RunnableDemo implements Runnable{
    private Thread t;
    private String threadName;

    RunnableDemo(String name){
        this.threadName = name;
        System.out.println("Createing "+threadName);
    }


    @Override
    public void run() {
        System.out.println("running "+threadName);
        m1();
        try {
            Thread.sleep(50);
//        for (int i = 4; i >0 ; i--) {
//            System.out.println("Thread: " + threadName + "," + i);
//        }
        }catch (InterruptedException e) {
            System.out.println("Thread:"+threadName+"intterupted");
        }
        System.out.println("Thread"+threadName+"exist");
    }

    public synchronized void m1(){
        System.out.println("m1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
    }
    public synchronized void m2(){
        System.out.println("m2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start(){
            System.out.println("Starting:"+threadName);
            if(t==null){
                t = new Thread(this,threadName);
                t.start();
            }
    }

    public static void main(String[] args) {
        RunnableDemo r1 = new RunnableDemo("Thread-1");
        r1.start();
        RunnableDemo r2 = new RunnableDemo("Thread-2");
        r2.start();
    }
}
