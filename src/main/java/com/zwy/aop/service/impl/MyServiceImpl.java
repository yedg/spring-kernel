package com.zwy.aop.service.impl;

import com.zwy.aop.service.MyService;

public class MyServiceImpl implements MyService {
    @Override
    public void myMethod() {
        System.out.println("myMethod invoke");
    }
}
