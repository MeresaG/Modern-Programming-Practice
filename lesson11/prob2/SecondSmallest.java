package lesson11.prob2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SecondSmallest {

	public static void main(String[] args) {

		List<Integer> input = List.of(2, 6, 7, 3, 9, 234, 54);
		System.out.println("The second smallest integer : " + secondSmallest(input));

		// 2. LocalDate types
		List<LocalDate> dates = new ArrayList<>();
		dates.add(LocalDate.of(2011, 1, 1));
		dates.add(LocalDate.of(2014, 2, 5));
		dates.add(LocalDate.of(2013, 2, 5));
		System.out.println("The second smalles date: " + secondSmallest(dates));

		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Bob", 50000));
		emps.add(new Manager("Steve", 60000));
		emps.add(new Employee("Harold", 70000));
		System.out.println( "The second least paid employee :" +
				secondSmallest1(emps, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)));
	}

	private static <T extends Comparable<? super T>> T secondSmallest(List<T> input) {

		T smallest = input.get(0);
		T secondSmallest = input.get(0);
		boolean flag = false;
		for (T element : input) {

			if (element.compareTo(smallest) < 0) {
				secondSmallest = smallest;
				smallest = element;
				flag = true;
			}

			else if (element.compareTo(secondSmallest) < 0) {

				secondSmallest = element;
				flag = true;

			}

			else if (element.compareTo(secondSmallest) > 0 && !flag) {
				secondSmallest = element;
			}

		}

		return secondSmallest;
	}

	
	private static <T> T secondSmallest1(List<T> input, Comparator<T> comparator) {

		T smallest = input.get(0);
		T secondSmallest = input.get(0);
		boolean flag = false;
		for (T element : input) {

			if (comparator.compare(element, smallest) < 0) {
				secondSmallest = smallest;
				smallest = element;
				flag = true;
			}

			else if (comparator.compare(element, secondSmallest) < 0) {

				secondSmallest = element;
				flag = true;

			}

			else if (comparator.compare(element, secondSmallest) > 0 && !flag) {
				secondSmallest = element;
			}

		}

		return secondSmallest;
	}

	
}
