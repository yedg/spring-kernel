package com.zwy.thread.concurrency3;

public class MyTest {

    Object object = new Object();

    public void method() {
        synchronized (object) {
            System.out.println("hello world");
            throw new RuntimeException("exception");
        }
    }
}
