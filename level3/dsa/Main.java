
public class Main {
	class MyThread extends Thread{
		@Override
		public void run() {
			EventDelegationExample d1 = new EventDelegationExample();
			EventDelegationExample d2 = new EventDelegationExample();
			d1.start();
			d2.start();
		}
	}

	public static void main(String[] args) {
		MyThread t1 = new Main().new MyThread();
		MyThread t2 = new Main().new MyThread();
		t1.start();
		t2.start();
	}

}

