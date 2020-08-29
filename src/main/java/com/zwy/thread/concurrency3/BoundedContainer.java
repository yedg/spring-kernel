package com.zwy.thread.concurrency3;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class BoundedContainer {
    private String[] elements = new String[10];
    private Lock lock = new ReentrantLock();
    private Condition notEmptyCondition = lock.newCondition();
    private Condition notFullCondition = lock.newCondition();
    private int putIndex;
    private int takeIndex;
    private int elementCount;

    public void put(String element) {
        this.lock.lock();
        try {
            while (this.elementCount==this.elements.length) {
                notFullCondition.await();
            }
            elements[putIndex++] = element;
            while (putIndex==this.elements.length){
                putIndex=0;
            }
            elementCount++;
            System.out.println(Thread.currentThread().getName()+":"+Arrays.toString(elements));
            System.out.println("now putIndex:" + putIndex);
            notEmptyCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.lock.unlock();
        }
    }

    public void take() {
        this.lock.lock();
        try {
            while (this.elementCount==0) {
                notEmptyCondition.await();
            }
            String result = elements[takeIndex];
            elements[takeIndex++]=null;
            while (takeIndex==this.elements.length){
                takeIndex=0;
            }
            elementCount--;
            System.out.println(result);
            System.out.println("arrays contain:" + Arrays.toString(elements));
            System.out.println("now takeIndex:" + takeIndex);
            notFullCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.lock.unlock();
        }
    }

    public static void main(String[] args) {
        BoundedContainer boundedContainer = new BoundedContainer();

        IntStream.range(0, 5).forEach(i -> new Thread(() -> {
            boundedContainer.take();
        }).start());
        IntStream.range(0, 5).forEach(i -> new Thread(() -> {
            boundedContainer.put("hello" + i);
        }).start());


    }

}
