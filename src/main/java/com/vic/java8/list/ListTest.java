package com.vic.java8.list;


import com.vic.entity.User;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTest {
	
	public static void main(String[] args) {
		// 测试交集、并集
//		test9();

		// 测试groupingBy分组
//		test8();

		// 从对象集合中取出某个字段的集合
//		test7();

		// 去重List
//		test6();

		// 合并两个list并去重
//		test5();

		// 过滤元素并设置默认值
//		test4();

		// 实现for循环中continue效果
//		test3();

		// 根据条件删除元素
//		test2();

		// 循环修改、打印元素
		test1();

	}

	private static void test9() {
		List<String> list1 = new ArrayList<>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("5");

		List<String> list2 = new ArrayList<>();
		list2.add("2");
		list2.add("3");
		list2.add("6");
		list2.add("7");

		// 交集
		List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());
		System.out.println("---交集 intersection---");
		intersection.parallelStream().forEach(System.out::println);

		// 差集 (list1 - list2)
		List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
		System.out.println("---差集 reduce1 (list1 - list2)---");
		reduce1.parallelStream().forEach(System.out::println);

		// 差集 (list2 - list1)
		List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(Collectors.toList());
		System.out.println("---差集 reduce2 (list2 - list1)---");
		reduce2.parallelStream().forEach(System.out::println);

		// 并集
		List<String> listAll = list1.parallelStream().collect(Collectors.toList());
		List<String> listAll2 = list2.parallelStream().collect(Collectors.toList());
		listAll.addAll(listAll2);
		System.out.println("---并集 listAll---");
		listAll.parallelStream().forEachOrdered(System.out::println);

		// 去重并集
		List<String> listAllDistinct = listAll.stream().distinct().collect(Collectors.toList());
		System.out.println("---得到去重并集 listAllDistinct---");
		listAllDistinct.parallelStream().forEachOrdered(System.out::println);
	}

	private static void test8() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("victor", "Tech"));
		list.add(new Employee("justin", "Tech"));
		list.add(new Employee("diana", "Financial"));
		list.add(new Employee("emma", "Financial"));

		Map<String, List<Employee>> map = list.stream()
				.collect(Collectors.groupingBy(Employee::getDeptNo));

		map.keySet().forEach(key -> System.out.println("map.get(" + key + ") = " + map.get(key)));

	}

	private static void test7() {
		List<User> lista = new ArrayList<>();
		lista.add(new User("u1", "p1"));
		lista.add(new User("u2", "p2"));
		lista.add(new User("u3", "p3"));

		List<String> names = lista.stream().map(p -> p.getUsername()).collect(Collectors.toList());
		List<String> names1 = lista.stream().map(User::getUsername).collect(Collectors.toList());
		names.forEach(System.out::println);
		names1.forEach(System.out::println);

	}

	private static void test6() {
		// 去重
		List<Long> list = new ArrayList<>();
		list.add(1L);
		list.add(187L);
		list.add(138L);
		list.add(138L);
		list.add(187L);
		list = list.stream().distinct().collect(Collectors.toList());
//		list.forEach(System.out::println);


		List<User> lista = new ArrayList<>();
		lista.add(new User("u1", "p1"));
		lista.add(new User("u2", "p1"));
		lista.add(new User("u3", "p2"));
		lista.add(new User("u4", "p3"));
		lista.add(new User("u5", "p3"));

		List<User> newList = lista.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(
				// 利用 TreeSet 的排序去重构造函数来达到去重元素的目的
				() -> new TreeSet<>(Comparator.comparing(User::getPsw))), ArrayList::new));

		newList.forEach(System.out::println);
	}

	private static void test5() {
		List<User> lista = new ArrayList<>();
		lista.add(new User("u1", "p1"));
		lista.add(new User("u2", "p2"));
		lista.add(new User("u3", "p3"));

		List<User> listb = new ArrayList<>();
		listb.add(new User("u3", "p3"));
		listb.add(new User("u4", "p4"));

		List<User> list = Stream.of(lista, listb).flatMap(Collection::stream).distinct().collect(Collectors.toList());


		// 根据用户名和密码去除重复数据
		List<User> distinctList = list.stream().collect(Collectors.collectingAndThen(
				Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getUsername() + ";" + o.getPsw()))), ArrayList::new));

		distinctList.forEach(System.out::println);
	}


	private static void testListToMap() {
		List<String> plans = new ArrayList<String>();
		plans.add("2018-01-09");
		plans.add("2018-02-09");
		plans.add("2018-03-09");
		plans.add("2018-04-09");
		plans.add("2018-05-09");
		plans.add("2019-01-09");
		plans.add("2019-03-09");
		plans.add("2020-01-09");
		plans.add("2020-02-09");
		plans.add("2020-03-09");

//		Map<String, List<String>> map = plans.stream().collect(Collectors.groupingBy(x -> x.toString().substring(0,  4), TreeMap::new, mapping));


		Map<String, List<String>> map = plans.stream().collect(
				Collectors.groupingBy(
						x -> x.substring(0,  4),
						Collectors.mapping(x -> x.substring(5, 10), Collectors.toList())
				)
		);

		LinkedHashMap<String, List<String>> collect = map.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		collect.keySet().forEach(key -> System.out.println("map.get(" + key + ") = " + map.get(key)));

		/*collect.forEach(item -> {
			System.out.println(item);
		});*/


		List<String> strings = new ArrayList<String>();
		strings.add("typeA:code1");
		strings.add("typeA:code2");
		strings.add("typeA:code3");
		strings.add("typeB:code4");
		strings.add("typeB:code5");
		strings.add("typeB:code6");
		strings.add("typeC:code7");

		Map<String, List<String>> result = strings.stream().collect(
				Collectors.groupingBy(s -> s.substring(0, s.indexOf(":")),
						Collectors.mapping(s -> s.substring(s.indexOf(":")+1), Collectors.toList())));

       /* for (Entry<String, List<String>> entry : result.entrySet())
        {
            System.out.println(entry);
        }*/

	}

	/**
	 * 过滤元素
	 */
	private static void test4() {
		List<User> list = new ArrayList<>();
		list.add(new User("u1", "p1"));
		list.add(new User(null, "p2"));
		list.add(new User("u3", "p3"));
		list.add(null);
		list.add(new User(null, "p4"));

		// 删除空元素
		list.removeIf(ele -> ele == null);

		// 姓名为空时，设置姓名为aa
		list.stream().filter(x -> x.getUsername() == null || "".equals(x.getUsername())).forEach(x ->
			x.setUsername("aa")
		);

		// 处理不为空的无素
		list.stream().filter(item -> item != null).forEach(item ->
			item.setUsername(item.getUsername() + "p")
		);

		list.forEach(System.out::println);
	}

	/**
	 * 实现for循环中continue效果
	 */
	private static void test3() {
		List<String> list = Arrays.asList("123", "123456", "12");
		list.forEach(e -> {
		    if(e.length() >= 5){
		        return;
		    }
		    System.out.println(e);
		}); 
	}

	/**
	 * 根据条件删除元素
	 */
	private static void test2() {
		List<User> list = new ArrayList<>();
		list.add(new User("u1", "p1"));
		list.add(new User("u2", "p2"));
		list.add(new User("u3", "p3"));

		Set<String> set = new HashSet<>();
		set.add("u1");
		set.add("u3");

		//method 1
		/*u1.removeIf(new Predicate<User>() {
			
			@Override
			public boolean test(User p) {
				return set.contains(p.getUsername());
			}
			
		});*/

		// 删除空元素
//		list.removeIf(ele -> ele == null);

		//method 2
		list.removeIf(ele -> set.contains(ele.getUsername()));

		list.forEach(System.out::println);
	}

	/**
	 * 循环修改、打印元素
	 */
	private static void test1() {
		List<User> list = new ArrayList<>();
		list.add(new User("u1", "p1"));
		list.add(new User("u2", "p2"));
		list.add(new User("u3", "p3"));

		//method 1
		list.forEach(item -> item.setUsername(item.getUsername() + "a"));

		//method 2
		list.forEach(System.out::println);
	}
	
}
