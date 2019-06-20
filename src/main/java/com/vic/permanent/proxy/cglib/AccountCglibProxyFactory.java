package com.vic.permanent.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB dynamic proxy
 * For the defect mentioned above that JDK only supports proxy of the delegate class 
 * with interface implemented, CGLIB solves this problem, 
 * so that its delegate class can also be a non-interface implemented class. 
 * CGLIB requires use of ASM, so we need to introduce asm-3.3.jar and cglib-2.2.2.jar in the following examples. 
 * 
 * @author Victor
 */
public class AccountCglibProxyFactory implements MethodInterceptor {

	private Object target;

	public Object getInstance(Object target) {
		this.target = target;
		return Enhancer.create(this.target.getClass(), this);

		// Enhancer enhancer = new Enhancer();//This class is used to generate a
		// proxy object.
		// enhancer.setSuperclass(this.target.getClass());//Set the parent
		// class.
		// enhancer.setCallback(this);//Set the callback object to itself.

		// return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		// Exclude the methods such as toString in the Object class.
		boolean objFlag = method.getDeclaringClass().getName().equals("java.lang.Object");
		if (!objFlag) {
			System.out.println("before");
		}
		Object result = null;
		// We usually use the proxy.invokeSuper(obj,args) method. This is easy
		// to understand - it is the method to implement the original class.
		// There is a another method: proxy.invoke(obj,args), which is a method
		// to implement the subclass generated.
		// If the incoming object is a subclass, an out-of-memory exception will
		// occur, because the subclass method enters the intercept method
		// constantly, and this method again comes to invoke the subclass
		// method, which leads to loop calls of the two methods.
		result = methodProxy.invokeSuper(obj, args);
		// result = methodProxy.invoke(obj, args);
		if (!objFlag) {
			System.out.println("after");
		}
		return result;
	}
}