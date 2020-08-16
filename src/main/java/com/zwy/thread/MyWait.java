package com.zwy.thread;

public class MyWait {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();

        synchronized (object){
            object.wait();
        }
    }
}
