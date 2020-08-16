package com.zwy.thread;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("myThread start");
    }

    public static void main(String[] args) {
        {
            MyThread myThread = new MyThread();
            myThread.start();
            System.out.println("main thread execute subThread");
        }
        {
            MyThread myThread = new MyThread();
            myThread.run();
            System.out.println("main thread execute subThread");
        }

    }
}
