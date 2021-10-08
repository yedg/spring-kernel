package com.zwy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class Test {
    public static void main(String[] args) {
        //代理类class文件存入本地磁盘
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/yedg/local/project/jvm/spring-kernel/");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback(new CglibProxyIntercepter());
        PersonService proxy = (PersonService) enhancer.create();
        proxy.setPerson();
        proxy.getPerson("1");
    }
}