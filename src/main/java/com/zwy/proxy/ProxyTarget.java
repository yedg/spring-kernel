package com.zwy.proxy;

public class ProxyTarget implements Target{
    private RealTarget realTarget;

    @Override
    public void myRequest() {

        if(realTarget==null){
            realTarget=new RealTarget();
        }
        beforeRequest();
        realTarget.myRequest();
        afterRequest();

    }

    public void beforeRequest(){
        System.out.println("before request");
    }

    public void afterRequest(){
        System.out.println("after request");
    }
}
