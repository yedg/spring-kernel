package com.zwy.cache;

public class AccountServiceImpl implements AccountService{
    private MyCacheManager<Account> cacheManager;

    public AccountServiceImpl() {
        this.cacheManager = new MyCacheManager<Account>();
    }

    @Override
    public Account getAccountByName(String name) {

        Account result=cacheManager.getValue(name);
        if(result!=null){
            return result;
        }
        result=getFromDB(name);
        if(result!=null){
            cacheManager.addOrUpdateCache(name,result);
        }
        return result;
    }

    private Account getFromDB(String name) {
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
