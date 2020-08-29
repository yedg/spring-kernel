package com.zwy.reflection;

public class MyTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<A> a = A.class;
        System.out.println(a.getName());

        /*System.out.println("---------------------");
        Class<?> a1 = Class.forName("com.zwy.reflection.A");
        System.out.println(a1.getName());*/


        System.out.println("---------------------");
        A a2 = new A();
        System.out.println("new A");
    }
}
