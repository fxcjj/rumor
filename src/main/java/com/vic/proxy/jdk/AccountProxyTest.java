package com.vic.proxy.jdk;
import com.vic.proxy.statistic.Account;
import com.vic.proxy.statistic.AccountImpl;

/**
 * Blog
 * https://www.alibabacloud.com/forum/read-386
 * https://blog.csdn.net/cckevincyh/article/details/54962920
 * 
 * @author Victor
 *
 */
public class AccountProxyTest {

	public static void main(String[] args) {
		// For the JDK proxy classes used below, one proxy can manage many interfaces.
		Account account1 = (Account) new AccountProxyFactory().bind(new AccountImpl());
		System.out.println(account1);
		account1.queryAccount();
	}
}