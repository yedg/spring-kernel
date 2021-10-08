package com.zwy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyClient {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        RealSubject realSubject = new RealSubject();
        InvocationHandler invocationHandler = new DynamicSubject(realSubject);
        Class<? extends InvocationHandler> aClass = invocationHandler.getClass();
        ClassLoader classLoader = aClass.getClassLoader();
        Subject subject = (Subject) Proxy.newProxyInstance(classLoader, realSubject.getClass().getInterfaces(), invocationHandler);

        subject.myRequest();
    }
}
