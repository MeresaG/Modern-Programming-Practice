package lesson10.prob6.b;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import lesson10.prob6.a.MultiThreadedTest;

public class SafeMultiThreadedTest {

	private static Executor exec = Executors.newCachedThreadPool();
	final Queue queue = new Queue();

	Runnable runnable = () -> {

		queue.addRemove(1,1);

	};

	public static void main(String[] args) {

		SafeMultiThreadedTest safeMultiThreadedTest = new SafeMultiThreadedTest();

		for (int i = 0; i < 10; i++) {

			safeMultiThreadedTest.multipleCalls();

		}

		System.out.println("Number of elements in the queue: " + safeMultiThreadedTest.queue.countElements());

	}

	public void multipleCalls() {
		for (int i = 0; i < 500; ++i) {
			exec.execute(runnable);
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
	}

}
