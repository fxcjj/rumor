package com.vic.generics;

/**
 * 泛型中通配符 —— 上界通配符 < ? extends E>
 * 上届：用 extends 关键字声明，表示参数化的类型可能是所指定的类型，或者是此类型的子类。
 *
 * 在类型参数中使用 extends 表示这个泛型中的参数必须是 E 或者 E 的子类，这样有两个好处：
 * 1) 如果传入的类型不是 E 或者 E 的子类，编译不成功
 * 2) 泛型中可以使用 E 的方法，要不然还得强转成 E 才能使用
 *
 */
public class GenericTest3 {
	/**
	 * 类型参数列表中如果有多个类型参数上限，用逗号分开
	 * @param arg1
	 * @param arg2
	 * @param <K>
	 * @param <E>
	 * @return
	 */
    private <K extends AA, E extends BB> E test(K arg1, E arg2) {
        E result = arg2;
		arg2.equals(arg1);
        //.....
        return result;
    }
}

class AA {
}

class BB {
}