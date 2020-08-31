package com.zwy.thread.concurrency3;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        threadLocal.set("hello world");

        System.out.println(threadLocal.get());

        threadLocal.set("welcome");
        System.out.println(threadLocal.get());
    }
}
