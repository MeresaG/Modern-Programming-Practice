package lesson8.prob5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MyConsumer {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", "Away", "On Vacation",
				"Everywhere you want to be");

		// Using Lambda expression
		list.forEach(l -> System.out.println(l.toUpperCase()));

		// Using Method reference
		System.out.println("------------------------------");
		MyConsumerInterface myConsumer = new MyConsumerInterface();
		list.forEach(myConsumer::accept);


	}

	static class MyConsumerInterface implements Consumer<String> {
		public void accept(String s) {
			System.out.println(s.toUpperCase());
		}
	}

}
