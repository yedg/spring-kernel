package com.zwy.reflection;

public class A {
    static {
        System.out.println("static block");
    }
    {
        System.out.println("dynamic block");
    }
}
