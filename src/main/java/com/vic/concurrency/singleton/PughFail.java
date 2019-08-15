package com.vic.concurrency.singleton;

public class PughFail {
	public static class Something {
		private Something() {
			super();
			System.out.println(this.getClass().getName() + " called");
			if (System.currentTimeMillis() > 0) {
				System.out.println("EMULATING INIT FAILURE");
				throw new RuntimeException("EMULATING INIT FAILURE");
			}
		}

		private static class LazyHolder {
			private static final Something INSTANCE = new Something();
		}

		public static Something getInstance() {
			return LazyHolder.INSTANCE;
		}
	}

	public static void main(String[] args) {
		System.out.println("First try");
		try {
			Something.getInstance();
		} catch (Throwable t) {
			System.out.println(t);
		}
		System.out.println("Second try");
		try {
			Something.getInstance();
		} catch (Throwable t) {
			System.out.println(t);
		}
	}
}