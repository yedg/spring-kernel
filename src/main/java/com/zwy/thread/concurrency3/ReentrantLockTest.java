package com.zwy.thread.concurrency3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    ReentrantLock lock = new ReentrantLock();

    public void method1() {
        try {
            lock.lock();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("method1 invoke");
        } finally {
            lock.unlock();
        }
    }

    public void method2() {
//        try {
//            lock.lock();
//            System.out.println("method2 invoke");
//        } finally {
//            lock.unlock();
//        }
        boolean result=false;
        try {
            result=lock.tryLock(800, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(result){
            System.out.println("get the lock");
        }else {
            System.out.println("cannot get the lock");
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                reentrantLockTest.method1();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                reentrantLockTest.method2();
            }
        });

        thread1.start();
        thread2.start();

    }
}
