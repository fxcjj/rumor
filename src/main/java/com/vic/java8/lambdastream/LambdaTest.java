package com.vic.java8.lambdastream;


import com.vic.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 10 example of lambda expression in java8
 * 
 * Read more: 
 * http://javarevisited.blogspot.jp/2014/02/10-example-of-lambda-expressions-in-java8.html#axzz56DlH8rp0
 * @author Victor
 * @date 2018年2月7日 下午1:37:15
 */
public class LambdaTest {
	
	public static void main(String[] args) {
		
//		testVariableReference();
			
//		test10();
		
//		test9();
		
//		test8();
		
//		test7();
		
//		test6_2();
		
//		test6();
		
//		test5();
		
//		test4();
		
//		test3();
		
		test2();
		 
//		test1();
		
	}
	
	/**
	 * One restriction with lambda expression is that, you can only reference either final 
	 * or effectively final local variables, which means you cannot modified a variable 
	 * declared in the outer scope inside a lambda.
	 */
	private static void testVariableReference() {
		List<Integer> primes = Arrays.asList(new Integer[]{2, 3, 5, 7}); 
		int factor = 2; 
		/*
		 * Compile time error: 
		 * Local variable factor defined in an enclosing scope must be final or effectively final
		 */
//		primes.forEach(element -> { factor++; });
		
		/*
		 * Btw, simply accessing them, without modifying is ok, as shown below :
		 */
		List<Integer> primes1 = Arrays.asList(new Integer[]{2, 3, 5, 7});
		int factor1 = 2;
		primes1.forEach(element -> { System.out.println(factor1 * element); });
	}

	/**
	 * Example 10: Calculating Maximum, Minimum, Sum and Average of List elements
	 * There is very useful method called summaryStattics() in stream classes like 
	 * IntStream, LongStream and DoubleStream.
	 * Which returns an IntSummaryStatistics, LongSummaryStatistics or DoubleSummaryStatistics
	 * describing various summary data about the elements of this stream.
	 * In following example, we have used this method to calculate maximum and minimum 
	 * number in a list. It also has getSum() and getAverage() which can give sum and 
	 * average of all numbers from list. 
	 */
	private static void test10() {
		//Get count, min, max, sum, and average for numbers
		List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 8);
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("max: " + stats.getMax());
		System.out.println("min: " + stats.getMin());
		System.out.println("sum: " + stats.getSum());
		System.out.println("average: " + stats.getAverage());
		/*
		 * output:
		 * max: 8
		 * min: 1
		 * sum: 24
		 * average: 4.8
		 */
	}
	
	/**
	 * Example 9: Creating a Sub List by copying distinct values
	 * This example shows how you can take advantage of distinct() method 
	 * of Stream class to filter duplicates in Collection.
	 */
	private static void test9() {
		List<Integer> numbers = Arrays.asList(1, 2, 2, 4, 5, 2, 4);
		List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.printf("Original List : %s, Square Without duplicates : %s %n", numbers, distinct);
	}
	
	/**
	 * Example 8: Applying function on Each element of List
	 * We often need to apply certain function to each element of List e.g.
	 * multiplying each element by certain number or dividing it, or doing anything with that.
	 * Those operations are perfectly suited for map() method, you can supply your 
	 * transformation logic to map() method as lambda expression and it will transform 
	 * each element of that collection, as shown in below example.
	 */
	private static void test8() {
		//Convert String to Uppercase and join them using coma
		List<String> countries = Arrays.asList("USA", "Japan", "France", "Germany", "Italy");
		String collect = countries.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(","));
		System.out.println(collect);
	}
	
	/**
	 * Example 7 : Creating a List of String by filtering
	 * Filtering is one of common operation Java Developers perform with large Collections,
	 * and you will surprise how much easy it is now to filter bulk data/large collection 
	 * using lambda expression and Stream API. Stream provides a filter() method, which accepts
	 * a Predicate object, means you can pass lambda expression to this method as filtering logic.
	 * Following examples of filtering collection in java with lambda expression will
	 * make it easy to understand.
	 */
	private static void test7() {
		//Create a List with String more than 2 characters
		List<String> strList = Arrays.asList("ab", "cd", "victor", "king", "martin", "carl");
		List<String> filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
		System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
		
		/*
		 * By the way, there is a common confusion regarding filter() method.
		 * In real world, when we filter, we left with something is not filtered,
		 * but in case of using filter() method, we get a new list which is actually
		 * filtered by satisfying criterion.
		 */
	}

	/**
	 * Example 6.2 - Map Reduce example using lambda expressions in Java 8
	 * In previous example, we have seen how map can transform each element of 
	 * a Collection class e.g. List. There is another function called reduce() which
	 * can combine all values into one.
	 * Map and Reduce operations are core of functional programming,
	 * reduce is also known as fold operation because of its folding nature.
	 * By the way reduce is not a new operation, you might have been already using it.
	 * 
	 * If you can recall SQL aggregate functions like sum(), avg() or count(),
	 * they are actually reduce operation because they accept multiple values and return 
	 * a single value. Stream API defines reduce() function which can accept a lambda expression, 
	 * and combine all values.
	 * Stream classes like IntStream has built-in methods like average(), count(), sum() to perform 
	 * reduce operations and mapToLong(), mapToDouble() methods for transformations.
	 * It doesn't limit you, you can either use built-in reduce function or can define yours.
	 * In this Java 8 Map Reduce example, we are first applying 12% VAT on all prices and then 
	 * calculating total of that by using reduce() method.
	 */
	private static void test6_2() {
		//Applying 12% VAT on each purchase
		//Old way: 
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double total = 0;
		for (Integer cost : costBeforeTax) {
			double price = cost + .12 * cost;
			total = total + price;
		}
		System.out.println("Total : " + total);
		
		//New way:
		double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
		System.out.println("Total : " + bill);
		
	}

	/**
	 * //[Java 8] (10) 使用Lambda完成函数组合，Map-Reduce以及并行化
	 * http://blog.csdn.net/dm_vincent/article/details/40856569
	 * 
	 * Example 6 : Map and Reduce example in java 8 using lambda expressions
	 * This example is about one of the popular functional programming concept called map.
	 * It allows you to transform your object.
	 * Like in this example we are transforming each element of costBeforeTax list to 
	 * including Value added Test. We passed a lambda expression x -> x*x to map() method
	 * which applies this to all elements of the stream.
	 * After that we use forEach() to print the all elements of list.
	 * You can actually get a list of all cost with tax by using Stream API's Collectors class.
	 * It has methods like toList() which will combine result of map or any other operation.
	 * Since Collector perform terminal operator on Stream, you can't re-use Stream after that.
	 * You can even use reduce() method from Stream API to reduce all numbers into one,
	 * which we will see in next example.
	 */
	private static void test6() {
		/*
		 * Applying 20% VAT on each purchase
		 * without lambda expressions
		 */
		List<Integer> costBeforeTax = Arrays.asList(200, 100, 300, 400);
		for(Integer cost : costBeforeTax) {
			double price = cost + .12 * cost;
			System.out.println(price);
		}
		
		/*
		 * With lambda expression
		 */
		costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);
	}
	
	/**
	 * Example 7 : How to combine Predicate in Lambda Expressions
	 * As i said previous example, java.util.function.Predicate. 
	 * Predicate allows you to combine two or more Predicate into one.
	 * It provides methods similar to logical operator AND and OR named as 
	 * and(), or() and xor(), which can be used to combine the condition you 
	 * are passing to filter() method. For example, in order to get all languages,
	 * which starts with J and are four character long, you can define two separate
	 * Predicate instance covering each condition and them combine them using Predicate.and() method,
	 * as shown in bleow example.
	 */
	private static void test5() {
		
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		
		/*
		 * We can even combine Predicate using and(), or() and xor() logical functions.
		 * for example to find names, which starts with J and four letter long, 
		 * you can pass combination of two Predicate.
		 */
		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		
		languages.stream()
			.filter(startsWithJ.and(fourLetterLong))
			.forEach((n) -> System.out.print("Name, which starts with J and four letter long is: " + n));
		
		/*
		 * Similarly you can also use or() and xor() method.
		 * This example also highlight important fact about using Predicate as individual condition 
		 * and then combing them as per your need. In short, you can use Predicate interface as traditional 
		 * Java imperative way, or you can take advantage of lambda expressions to write less and do more.
		 */
	}

	/**
	 * Example 4 - Using Lambda expression and Functional interface Predicate
	 * Apart from providing support for functional programming idioms at language level, 
	 * Java 8 has also added a new package called java.util.function, 
	 * which contains lot of classes to enable functional programming in Java. 
	 * One of them is Predicate, By using java.util.function.Predicate functional interface 
	 * and lambda expressions, you can provide logic to API methods to add lot of dynamic behaviour 
	 * in less code. Following examples of Predicate in Java 8 shows lot of common ways 
	 * to filter Collection data in Java code. Predicate interface is great for filtering.
	 */
	private static void test4() {
		
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		System.out.println("Languages which start with J: ");
		filter(languages, (str) -> str.startsWith("J"));
		
		System.out.println("Languages which ends with a: ");
		filter(languages, (str) -> str.endsWith("a"));
		
		System.out.println("Print all languages: ");
		filter(languages, (str) -> true);
		
		System.out.println("Print no languages: ");
		filter(languages, (str) -> false);
		
		System.out.println("Print language whose length greater than 4: ");
		filter(languages, (str) -> str.length() > 4);
		
		
	}
	
	//Even better
	public static void filter(List<String> languages, Predicate<String> condition) {
		
		languages.stream().filter((name) -> condition.test(name)).forEach((name) -> {
			System.out.println(name);
		});
		
		/*
		 * You can see that filter method from Stream API also accept a Predicate, 
		 * which means you can actually replace out custom filter() method with the in-line code
		 * written inside it, that's the power of lambda expression. By the way, Predicate interface 
		 * also allows you test for multiple condition, which we will see in out next example.
		 */
	}
	
	/**
	 * 过滤
	 * @param languages
	 * @param condition
	 */
	@Deprecated
	public static void filter_old(List<String> languages, Predicate<String> condition) {
		for(String l : languages) {
			if(condition.test(l)) {
				System.out.println(l+" ");
			}
		}
	}


	/**
	 * Example 3 - Iterating over List using Lambda expressions
	 * If you are doing Java for few years, you know that most common operation 
	 * with Collection classes are iterating over them and applying business logic 
	 * on each elements, for example processing a list of orders, trades and events. 
	 * Since Java is an imperative language, all code looping code written prior to Java 8 
	 * was sequential i.e. their is on simple way to do parallel processing of list items. 
	 * If you want to do parallel filtering, you need to write your own code, which is not 
	 * as easy as it looks. Introduction of lambda expression and default methods has separated 
	 * what to do from how to do, which means now Java Collection knows how to iterate, 
	 * and they can now provide parallel processing of Collection elements at API level. 
	 * In below example, I have shown you how to iterate over List using with and without 
	 * lambda expressions, you can see that now List has a forEach() method, which can iterate 
	 * through all objects and can apply whatever you ask using lambda code.
	 * 
	 * The last example of looping over List shows how to use method reference in Java 8. 
	 * You see the double colon, scope resolution operator form C++, it is now used for 
	 * method reference in Java 8.
	 */
	private static void test3() {
		
		//Prior Java 8:
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		/*for(String feature : features) {
			System.out.println(feature);
		}*/
		
		//In java 8:
//		features.forEach(f -> System.out.println(f));
		
		/*
		 * Even better use Method reference feature of Java 8
		 * method reference is denoted by :: (double colon) operator
		 * looks similar to score resolution operator of C++
		 */
		features.forEach(System.out::println);
	}


	/**
	 * Example 2 - Event handling using Java 8 Lambda expressions
	 * If you have ever done coding in Swing API, you will never forget writing event listener code. 
	 * This is another classic use case of plain old Anonymous class, but no more. 
	 * You can write better event listener code using lambda expressions as shown below.
	 * 
	 * Another place where Java developers frequently use anonymous class is for providing 
	 * custom Comparator to Collections.sort() method. In Java 8, you can replace your ugly 
	 * anonymous class with more readable lambda expression. I leave that to you for exercise,
	 * should be easy if you follow the pattern, I have shown during implementing Runnable 
	 * and ActionListener using lambda expression.           
	 */
	private static void test2() {
		//Before java 8
		/*JButton show = new JButton("Show");
		show.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Event handling without lambda expression is boring");
			}
			
		});*/
		
		//Java 8 way
		/*show.addActionListener((e) -> {
			System.out.println("Light, camera, action! Lambda expresssions Rocks");
		});*/
		
		List<User> list = new ArrayList<User>();
		list.add(new User("u1", "p4", 3));
		list.add(new User("u3", "p3", 6));
		list.add(new User("u1", "p1", 1));
		list.add(new User("u2", "p2", 9));
		
		//option 1
//		list.sort((User u1, User u2) -> u2.getUsername().compareTo(u1.getUsername()));
		
		//option 2
		//简化
		/*list.sort((u1, u2) -> {
			//do something here.
			return u2.getUsername().compareTo(u1.getUsername());
		});*/
		
		//option 3
		//静态方法引用
//		list.sort(LambdaTest::compareByUsername);
		
		//option 4
		//使用增强版的Comparator接口
//		Collections.sort(list, Comparator.comparing(User::getUsername));
		
		//also can reverse
//		Collections.sort(list, Comparator.comparing(User::getUsername).reversed());
		
		//使用Comparator进行组合
//		Collections.sort(list, Comparator.comparing(User::getUsername).thenComparing(User::getPsw));
		
		list.sort((u1, u2) -> {
			//do something here.
			return u1.getSeq_no().compareTo(u2.getSeq_no());
		});
		
		list.forEach(e -> System.out.println(e));
		
	}
	
	/**
	 * 使用静态方法的引用代替
	 * @param u1
	 * @param u2
	 * @return
	 */
	public static int compareByUsername(User u1, User u2) {
		return u2.getUsername().compareTo(u1.getUsername());
	}

	/**
	 * Example 1 - implementing Runnable using Lambda expression 
	 * One of the first thing, I did with Java 8 was trying to replace 
	 * anonymous class with lambda expressions, and what could have been 
	 * best example of anonymous class then implementing Runnable interface. 
	 * Look at the code of implementing runnable prior to Java 8, it's taking 
	 * four lines, but with lambda expressions, it's just taking one line. 
	 * What we did here? the whole anonymous class is replaced by () -> {} code block.
	 * 
	 * This example brings us syntax of lambda expression in Java 8. 
	 * You can write following kind of code using lambdas :
	(params) -> expression
	(params) -> statement
	(params) -> { statements }
	for example, if your method don't change/write a parameter and just print something on console, you can write it like this :
	() -> System.out.println("Hello Lambda Expressions");
	If your method accept two parameters then you can write them like below :
	(int even, int odd) -> even + odd
	By the way, it's general practice to keep variable name short inside lambda expressions. This makes your code shorter, 
	allowing it to fit in one line. So in above code, choice of variable names as a,b or x, y is better than even and odd.
	 */
	private static void test1() {
		//Before java 8
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Before java8, too much code for too little to do");
			}
			
		}).start();
		
		//Java 8 way
		new Thread(() -> System.out.println("In java8, lambda expression rocks!")).start();
		
	}
	
	
}
