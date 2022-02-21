package lesson9.prob10.c;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyIntStream {

	public static void main(String[] args) {
		
		Stream<Integer> myIntStream = Stream.of(1, 2, 6, 9 , 45, 134);
		
		IntSummaryStatistics stat =  myIntStream.collect(Collectors.summarizingInt(x -> x));
		System.out.println("Max: "+stat.getMax());
		System.out.println("Min: "+stat.getMin());
		
	}
	

	
}
