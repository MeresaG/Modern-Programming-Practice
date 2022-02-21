package lesson9.prob10.a;

import java.util.*;

public class Or {

	public static void main(String[] args) {
		List<Simple> list = Arrays.asList(new Simple(false), new Simple(false), new Simple(true));

		System.out.println(someSimpleIsTrue(list));
	}

	public static boolean someSimpleIsTrue(List<Simple> list) {
		
		/*
		 * boolean accum = false;
		 * 
		 * for (Simple s : list) { accum = accum || s.flag; }
		 * 
		 * return accum;
		 */

		return list.stream()
				.map(x -> x.flag)
				.reduce(false, (x, y) -> x || y);
		
	}

}