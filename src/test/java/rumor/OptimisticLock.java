package rumor;

public class OptimisticLock {
	
	static int value = 0;
	
	public static void main(String[] args) {
		new Thread(new Runnable() {//A线程
            public void run() {
                try {
                    for (int i = 0; i < 3; i++) {
                        int Avalue = OptimisticLock.value;//A获取的value
                        OptimisticLock.invoke(Avalue, "A");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {//B线程
            public void run() {
                try {
                    for (int i = 0; i < 3; i++) {
                        int Bvalue = OptimisticLock.value;//B获取的value
                        OptimisticLock.invoke1(Bvalue, "B");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
	}
	
	
	/**
	 * A线程要执行的方法
	 * @param a
	 * @param str
	 * @throws InterruptedException 
	 */
	public static void invoke(int a, String str) throws InterruptedException {
		//模拟执行时间
		Thread.sleep(1000L);
		if(a != value) {
			System.out.println("version is different, a: " + a + ", value: " + value);
		} else {
			a++;
			value = a;
			System.out.println(str + ", " + value);
		}
	}
	
	public static void invoke1(int b, String str) throws InterruptedException {
		//模拟执行时间
		Thread.sleep(1000L);
		if(b != value) {
			System.out.println("version is different, b: " + b + ", value: " + value);
		} else {
			b++;
			value = b;
			System.out.println(str + ", " + value);
		}
	}
	
	
	
}
