package com.vic.java8.list;


import com.vic.entity.User;

import java.util.*;
import java.util.stream.Collectors;

public class ListTest {
	
	public static void main(String[] args) {
		List<User> u1 = new ArrayList<User>();
		u1.add(new User("u1", "p1"));
		u1.add(new User(null, "p2"));
		u1.add(new User("u3", "p3"));
		u1.add(new User(null, "p4"));
		
		u1.stream().filter(x -> x.getUsername() == null || "".equals(x.getUsername())).forEach(x -> {
			x.setUsername("aaaaaa");
		});
		
		u1.forEach(System.out::println);
		
		//don't dispose null element, and reset username
		/*u1.stream().filter(item -> item != null).forEach(item -> {
			item.setUsername(item.getUsername()+"--------");
		});
		
		//delete null element
		u1.removeIf(ele -> ele == null);
		
		//print
		u1.forEach(item -> {
			System.out.println(item);
		});*/
		
//		testRemoveIf();
		
		
//		testListToMap();
		
//		testContinue();
		

	}

	private static void testContinue() {
		List<String> list = Arrays.asList("123", "45634", "7892", "abch", "sdfhrthj", "mvkd");  
		list.stream().forEach(e -> {
		    if(e.length() >= 5){  
		        return;  
		    }  
		    System.out.println(e);  
		}); 
		
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
				x -> x.toString().substring(0,  4),
				Collectors.mapping(x -> x.toString().substring(5, 10), Collectors.toList())
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

	private static void testRemoveIf() {
		List<User> u1 = new ArrayList<User>();
		u1.add(new User("u1", "p1"));
		u1.add(new User("u2", "p2"));
		u1.add(new User("u3", "p3"));
		u1.add(new User("u4", "p4"));
		
		Set<String> set = new HashSet<String>();
		set.add("u1");
		set.add("u4");
		
		//method 1
		/*u1.removeIf(new Predicate<User>() {
			
			@Override
			public boolean test(User p) {
				return set.contains(p.getUsername());
			}
			
		});*/
		
		//method 2
		u1.removeIf(ele -> set.contains(ele.getUsername()));
		
		u1.forEach(ele -> System.out.println(ele));
	}
	
}
