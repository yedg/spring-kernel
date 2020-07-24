package com.zwy.proxy;

public class RealTarget implements Target {
    @Override
    public void myRequest() {
        System.out.println("from Target Object");
    }
}
