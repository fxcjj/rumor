package com.vic.permanent.proxy.cglib;

import com.vic.permanent.proxy.statistic.Account;
import com.vic.permanent.proxy.statistic.AccountImpl;

public class AccountProxyTest { 

    public static void main(String[] args) { 
        //The following are the proxies using CGLIB. 
        //1. Support the classes with interface implemented 
        Account account2 = (Account)new AccountCglibProxyFactory().getInstance(new AccountImpl());
        account2.updateAccount(); 

        // 2. Support the classes with interface unimplemented 
        Person person = (Person)new AccountCglibProxyFactory().getInstance(new Person()); 
        System.out.println(person); 
        person.show(); 
    } 
}