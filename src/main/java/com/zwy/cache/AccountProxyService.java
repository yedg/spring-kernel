package com.zwy.cache;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AccountProxyService implements MethodInterceptor {
    private MyCacheManager<Account> cacheManager;

    public AccountProxyService() {
        this.cacheManager = new MyCacheManager<Account>();
    }
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] arguments = invocation.getArguments();
        Account account = cacheManager.getValue((String) arguments[0]);
        if(account!=null){
            return account;
        }
        account =(Account) invocation.proceed();
        if(account!=null){
            cacheManager.addOrUpdateCache((String)arguments[0],account);
        }
        return account;
    }
}
