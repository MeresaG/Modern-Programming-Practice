package lesson8.prob1;

import java.util.function.Supplier;

public class LambdaExpression {

	public static final Supplier<Double> DOUBLE_SUPPLIER = Math::random;

	public static void main(String[] args) {

		// i. Rewrite this method reference as a lambda expression
		Supplier<Double> f = () -> Math.random();

		/*
		 * 2. Put this method expression in a main method in a Java class and use it to
		 * print a random number to the console
		 */

		System.out.println(f.get());
		System.out.println(DOUBLE_SUPPLIER.get());

		/*
		 * 3. Create an equivalent Java class in which the functional behavior of
		 * Math::random is expressed using an inner class (implementing Supplier ); call
		 * this inner class from a main method and use it to output a random number to
		 * the console. The behavior should be the same as in part ii.
		 */

		class MySupplier implements Supplier<Double> {
			
			@Override
			public Double get() {
				return Math.random();
			}
			
		}

		// calling it
		Supplier supplier = new MySupplier();
		System.out.println(supplier.get());

	}

}
