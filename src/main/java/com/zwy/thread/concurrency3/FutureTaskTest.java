package com.zwy.thread.concurrency3;

import java.util.Random;
import java.util.concurrent.*;

public class FutureTaskTest {

    public static void main(String[] args) {

        Callable<Integer> callable=()->{
            System.out.println(" pre execution");

            Thread.sleep(5000);
            int random = new Random().nextInt(500);

            System.out.println(" post execution");

            return random;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

        System.out.println("thread has started ");

        try {
            Thread.sleep(2000);
//            FutureTask.get() it will block main thread
            System.out.println(futureTask.get());
            System.out.println("main get thread return");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
