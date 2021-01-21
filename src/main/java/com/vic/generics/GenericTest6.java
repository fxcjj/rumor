package com.vic.generics;

/**
 *
 * https://www.cnblogs.com/cangqinglang/p/11626410.html
 */
public class GenericTest6 {

	public static void main(String[] args) {
		/*
		1) 为什么要用通配符和边界？
		编译器认为逻辑是这样的：
		a) Apple IS-A Fruit，有父子关系
		b) 装Apple的盘子 NOT-IS-A 装水果的盘子
		所以正面这行代码，无法从Plate<Apple>转换为Plate<Fruit>
		 */
//		Plate<Fruit> plate = new Plate<Apple>(new Apple()); // compilation error

		/*
		2) 什么是上界？
		Plate<？ extends Fruit>, 翻译成人话就是：一个能放水果以及一切是水果派生类的盘子。再直白点就是：啥水果都能放的盘子。
		这和我们人类的逻辑就比较接近了。Plate<？ extends Fruit>和Plate<Apple>最大的区别就是：Plate<？ extends Fruit>是Plate<Fruit>以及Plate<Apple>的基类（即父类）。
		直接的好处就是，我们可以用“苹果盘子”给“水果盘子”赋值了。
		 */
		Plate<? extends Fruit> p = new Plate<Apple>(new Apple());

		/*
		3) 什么是下界？
		Plate<？ super Fruit>, 表达的就是相反的概念：一个能放水果以及一切是水果基类的盘子。Plate<？ super Fruit>是Plate<Fruit>的基类（即父类），但不是Plate<Apple>的基类。
		 */

		/*
		4) 上下界通配符的副作用
		边界让Java不同泛型之间的转换更容易了。但不要忘记，这样的转换也有一定的副作用。那就是容器的部分功能可能失效。
		还是以刚才的Plate为例。我们可以对盘子做两件事，往盘子里set( )新东西，以及从盘子里get( )东西。
		 */

		/*
		4.1) 上界<? extends T>不能往里存，只能往外取
		<? extends Fruit>会使往盘子里放东西的set()方法失效。但取东西get()方法还有效。比如下面例子里两个set()方法，插入Apple和Fruit都报错。
		 */
		Plate<? extends Fruit> fruitPlate = new Plate<Apple>(new Apple());
		// 不能存入任何元素
//		fruitPlate.setItem(new Fruit()); // compilation error
//		fruitPlate.setItem(new Apple()); // compilation error
//		fruitPlate.setItem(new Object()); // compilation error

		// 读取的东西只能放在Fruit或它的基类里
		Fruit newFruit1 = fruitPlate.getItem();
		Object newFruit2 = fruitPlate.getItem();
//		Apple newFruit3 = fruitPlate.getItem();  // compilation error

		/*
		原因是编译器只知道容器内是Fruit或者它的派生类，但具体是什么类型不知道。
		可能是Fruit？可能是Apple？也可能是Banana，RedApple，GreenApple？编译器在看到后面用Plate<Apple>赋值以后，盘子里没有被标上有“苹果”。
		而是标上一个占位符：CAP#1，来表示捕获一个Fruit或Fruit的子类，具体是什么类不知道，代号CAP#1。
		然后无论是想往里插入Apple或者Meat或者Fruit编译器都不知道能不能和这个CAP#1匹配，所以就都不允许。

		所以通配符<?>和类型参数<T>的区别就在于，对编译器来说所有的T都代表同一种类型。比如下面这个泛型方法里，三个T都指代同一个类型，要么都是String，要么都是Integer。

		public <T> List<T> fill(T... t);
		但通配符<?>没有这种约束，Plate<?>单纯的就表示：盘子里放了一个东西，是什么我不知道。
		 */


		/*
		4.2) 下界<? super T>不影响往里存，但往外取只能放在Object对象里
		使用下界<? super Fruit>会使从盘子里取东西的get( )方法部分失效，只能存放到Object对象里。set( )方法正常。
		 */
		// 构造器限制为Fruit类型
		Plate<? super Fruit> fruitPlate1 = new Plate<Fruit>(new Fruit());
		// 存入元素正常
		fruitPlate1.setItem(new Fruit());
		fruitPlate1.setItem(new Apple()); // 也是Fruit
//		fruitPlate1.setItem(new Object()); // compilation error

		// 读取出来的东西只能存放在Object类里
		Object newFruita = fruitPlate1.getItem();
//		Fruit newFruitb = fruitPlate1.getItem();  // compilation error
//		Apple newFruitc = fruitPlate1.getItem();  // compilation error

		/*
		因为下界规定了元素的最小粒度的下限，实际上是放松了容器元素的类型控制。既然“放入元素”是Fruit的基类（即父类），那往里存粒度比Fruit小的都可以。
		但往外读取元素就费劲了，只有所有类的基类Object对象才能装下。但这样的话，元素的类型信息就全部丢失。
		 */

		/*
		5) PECS原则
		最后看一下什么是PECS（Producer Extends Consumer Super）原则，已经很好理解了：
		a) 频繁往外读取内容的，适合用上界Extends。
		b) 经常往里插入的，适合用下界Super。
		 */

	}


}

class Plate<T> {

	private T item;

	public Plate(T item) {
		this.item = item;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
}

// Lev 1
class Food {}

// Lev 2
class Fruit extends Food {}
class Meat extends Food {}

// Lev 3
class Apple extends Fruit {}
class Banana extends Fruit{}
class Pork extends Meat{}
class Beef extends Meat{}

// Lev 4
class ReadApple extends Apple{}
class GreenApple extends Apple{}