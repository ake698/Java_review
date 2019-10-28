package com.nowcoder.ThreadDemo;

public class DeadLock {
    private static final String r1="a";
    private static final String r2="b";

    static class ThreadA implements Runnable{
        @Override
        public void run() {
            synchronized (r1){
                System.out.println("A.....1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (r2){
                    System.out.println("A...........2");
                }
            }
        }
    }

    static class ThreadB implements Runnable{
        @Override
        public void run() {
            synchronized (r2){
                System.out.println("B..............1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (r1){
                    System.out.println("B....................2");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadA());
        t1.start();
        Thread t2 = new Thread(new ThreadB());
        t2.start();
    }
}


