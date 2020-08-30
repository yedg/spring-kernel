package com.zwy.thread.concurrency3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {

    public static void main(String[] args) {
        String result = CompletableFuture.supplyAsync(() -> "hello").thenApply(s1 -> s1 + " world").join();
        System.out.println(result);

        System.out.println("=============");

        CompletableFuture.supplyAsync(()->"hello").thenAcceptAsync(s1-> System.out.println(s1+" world"));

        System.out.println("=============");

        result=CompletableFuture.supplyAsync( ()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenCombineAsync(CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }),(s1,s2)->s1+" "+s2).join();
        System.out.println(result);


        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("completable finished");
        });

        completableFuture.whenComplete((t,action)-> System.out.println("thread finished"));

        System.out.println("main thread finished");

        try {
            TimeUnit.MILLISECONDS.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
