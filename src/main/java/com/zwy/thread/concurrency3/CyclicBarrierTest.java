package com.zwy.thread.concurrency3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
            System.out.println("hello world");
        });

        for(int n=0;n<3;n++){
            IntStream.range(0,3).forEach(i->new Thread(()->{
                try {
                    Thread.sleep(2000);
                    int random = new Random().nextInt();
                    System.out.println("hell0"+random);
                    cyclicBarrier.await();
                    System.out.println("world"+random);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start());
        }
    }
}
