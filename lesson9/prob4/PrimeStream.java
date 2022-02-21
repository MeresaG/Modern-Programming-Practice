package lesson9.prob4;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeStream {

	// A.
	final Stream<Integer> primes = Stream.iterate(1, PrimeStream::getPrime);

	// B.
	public void printFirstNPrimes(int num) {

		Stream<Integer> primeList = Stream.iterate(1, PrimeStream::getPrime).limit(num);
		System.out.println(Arrays.toString(primeList.toArray()));

	}

	// generate prime number
	/**
	 * Iteratively finds prime numbers after a given number
	 *
	 * @param number
	 * @return
	 */
	private static int getPrime(int number) {
		
		if (isPrime(number + 1))
			return number + 1;
		else
			return getPrime(number + 1);
	}

	// Java 8 way to check if the number is prime or not
	public static boolean isPrime(int number) {
		return number > 1
				&& IntStream.rangeClosed(2, number/2).noneMatch(divisor -> number % divisor == 0);
	}

	public static void main(String[] args) {
		PrimeStream ps = new PrimeStream(); // PrimeStream is enclosing class
		ps.printFirstNPrimes(10);
		System.out.println("====");
		ps.printFirstNPrimes(5);
	}

}
