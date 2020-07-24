package com.zwy.proxy;

public class ProxyClient {
    public static void main(String[] args) {
        Target target = new ProxyTarget();
        target.myRequest();
    }
}
