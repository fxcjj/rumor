package com.vic.permanent.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  JDK dynamic proxy 
 *  The use of JDK dynamic proxy involves a Proxy class and an InvocationHandler interface. 
 *  Proxy has been designed very beautiful, but it is a little bit pity that it only supports interface 
 *  proxy (namely, the proxy class must implement interfaces), and this pity is doomed because of its design. 
 *  
 * @author Victor
 */
public class AccountProxyFactory implements InvocationHandler {

	private Object target;

	public Object bind(Object target) {
		// JDK dynamic proxy is used here, which must be bound with interfaces,
		// and our businesses may be implemented without involving the
		// interfaces. So this defect is remedied by CGLIB.
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// System.out.println(Proxy.isProxyClass(proxy.getClass()));
		boolean objFlag = method.getDeclaringClass().getName().equals("java.lang.Object");

		Object result = null;
		if (!objFlag)
			System.out.println("Implement proxy before");
		result = method.invoke(this.target, args);
		if (!objFlag)
			System.out.println("Implement proxy after");
		return result;
	}
}
