package com.zwy.thread.concurrency3;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        IntStream.range(0,3).forEach(i->new Thread(()->{
            try {
                Thread.sleep(2);
                System.out.println("hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        }).start());

        System.out.println("subThread start finished");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main Thread start finished");

    }
}
