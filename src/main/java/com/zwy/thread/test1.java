package com.zwy.thread;

public class test1 {
    static class Counter {
        int count = 0;

        public synchronized void add() {
            while (count != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            System.out.println(Thread.currentThread().getName() + ":" + count);
            notify();
        }

        public synchronized void minus() {
                    while (count != 1) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count --;
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                   notify();
                }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread addThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    counter.add();
                }
            }
        });
        Thread minusThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    counter.minus();
                }
            }
        });
        addThread.start();
        minusThread.start();

    }
}
