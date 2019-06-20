package rumor;

public class InnerClassDemo3 {
	public static void main(String[] args) {
		new Outer().method();
	}
}

class Outer {
	
	int num = 3;
	
	void method() {
		
		final int x = 8;// int前需要加final吗？
		class Inner {
			void show() {
				Outer out = new Outer();
				out.method();
				System.out.println("show...."+x);//从内部类中访问局部变量，需要被声明为最终类型？？？ //这个说法对吗？
			}
		}
		
		Inner in = new Inner();
		in.show();
	}
}
