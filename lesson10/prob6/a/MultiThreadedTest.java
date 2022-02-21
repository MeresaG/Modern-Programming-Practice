package lesson10.prob6.a;

public class MultiThreadedTest {

	final Queue queue = new Queue();

	Runnable runnable = () -> {
		
		queue.add(1); queue.add(1); queue.remove();
		
	};

	public static void main(String[] args) {

		MultiThreadedTest multiThreadedTest = new MultiThreadedTest();

		for (int i = 0; i < 10; i++) {

			multiThreadedTest.multipleCalls();

		}

		System.out.println("Number of elements in the queue: " +multiThreadedTest.queue.countElements());

	}

	public void multipleCalls() {

		for (int i = 0; i < 500; i++) {
			new Thread(runnable).start();
		}

	}

}
