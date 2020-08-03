package com.zwy.cache;

public class MyCacheClient {
    public static void main(String[] args) {
        AccountServiceImpl service = new AccountServiceImpl();
        long start=System.currentTimeMillis();
        service.getAccountByName("zwy");
        long end1=System.currentTimeMillis();
        service.getAccountByName("zwy");
        long end2=System.currentTimeMillis();
        System.out.println("第一次查询耗时:"+(end1-start));
        System.out.println("第二次查询耗时:"+(end2-end1));
    }
}
