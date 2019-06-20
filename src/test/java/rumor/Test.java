package rumor;

public class Test {
	
	static int count = 10;
	
	public static void main(String[] args) {
		
		/*Test t1 = new Test();
		Test t2 = new Test();
//		System.out.println(t1.equals(t2));
		
		String s1 = new String("a");
		String s2 = new String("a");
		
		System.out.println(s1.equals(s2));*/
		count++;
		int a = count;
		System.out.println(count);
		System.out.println(a);
		
		
	}

	
}


interface Animal {
	void say();
}

class Cat implements Animal {
	@Override
	public void say() {
		System.out.println("喵儿");
	}
}

class Dog implements Animal {
	@Override
	public void say() {
		System.out.println("汪汪");
	}
}



