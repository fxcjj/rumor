package com.vic.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型中通配符 —— 下界通配符 < ? super E>
 * 下界: 用 super 进行声明，表示参数化的类型可能是所指定的类型，或者是此类型的父类型，直至 Object
 *
 * 在类型参数中使用 super 表示这个泛型中的参数必须是 E 或者 E 的父类。
 *
 */
public class GenericTest4<T> {

	/**
	 * dst 类型 “大于等于” src 的类型，这里的“大于等于”是指 dst 表示的范围比 src 要大，因此装得下 dst 的容器也就能装 src 。
	 * @param dst
	 * @param src
	 * @param <T> 限制参数列表中T一致
	 */
	private <T> void test(List<? super T> dst, List<T> src) {
		for (T t : src) {
			dst.add(t);
		}
	}

	public static void main(String[] args) {
		List<MaleLion> maleLions = new ArrayList<>();
		maleLions.add(new MaleLion("a"));
		maleLions.add(new MaleLion("b"));

		List<Lion> lions = new ArrayList<>();
		new GenericTest4().test(lions, maleLions);

		lions.forEach(e -> System.out.println(e.name));

	}
}

class Lion {
	String name;
}

class MaleLion extends Lion {
	public MaleLion(String name) {
		this.name = name;
	}

}

