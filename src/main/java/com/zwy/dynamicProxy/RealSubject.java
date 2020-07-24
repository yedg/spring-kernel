package com.zwy.dynamicProxy;

public class RealSubject implements Subject{
    @Override
    public void myRequest() {
        System.out.println("from realSubject request");
    }
}
