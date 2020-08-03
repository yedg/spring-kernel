package com.zwy.cache;

public class AccountOnlyService implements AccountService{

    public Account getAccountByName(String name){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("get from db");
        Account result = new Account(1, "zwy");
        return result;
    }
}
