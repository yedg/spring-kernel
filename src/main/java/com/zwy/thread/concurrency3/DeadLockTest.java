package com.zwy.thread.concurrency3;

public class DeadLockTest {
    private Object object1 = new Object();
    private Object object2 = new Object();

    public void method1() {
        synchronized (object1) {
            synchronized (object2) {
                System.out.println("method1");
            }
        }
    }

    public void method2() {
        synchronized (object2) {
            synchronized (object1) {
                System.out.println("method2");
            }
        }
    }

    public static void main(String[] args) {
        DeadLockTest lockTest = new DeadLockTest();
        Runnable runnable1 = () -> {
            while (true) {
                lockTest.method1();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        final Thread thread1 = new Thread(runnable1, "thread1");
        Runnable runnable2 = () -> {
            while (true) {
                lockTest.method2();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        final Thread thread2 = new Thread(runnable2, "thread1");

        thread1.start();
        thread2.start();
    }
}
