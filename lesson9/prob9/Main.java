package lesson9.prob9;


import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	//final static Function<Integer, IntStream> myIntStream = n -> IntStream.iterate(1, Main::getSquare).limit(n);

	public static void main(String[] args) {

		int n = 4;
		printSquares(n);

	}

	private static boolean checkSquare(double x) {
		
		double sq = Math.sqrt(x);
		return ((sq - Math.floor(sq)) == 0);
		
	}

	public static int getSquare(int number) {

		if (checkSquare(number + 1))
			return number + 1;
		else
			return getSquare(number + 1);

	}

	public static void printSquares(int num) {
		
		System.out.println(IntStream.iterate(1, Main::getSquare).limit(num).boxed().collect(Collectors.toList()));

		//System.out.println(myIntStream.apply(num).boxed().collect(Collectors.toList()));

	}

}
