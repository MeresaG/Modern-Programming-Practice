package lesson8.prob6;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Examples {

	// a. (Employee e) -> e.getName()
	// Used ClassName::InstanceMethod
	final Function<Employee, String> getEmployeeName = e -> e.getName();
	final Function<Employee, String> getEmployeeName1 = Employee::getName;

	// B. (Employee e,String s) -> e.setName(s)
	// Used ClassName::InstanceMethod
	final BiConsumer<Employee, String> setEmployeeName = Employee::setName;
	final BiConsumer<Employee, String> setEmployeeName1 = (e, s) -> e.setName(s);

	// C. (String s1,String s2) -> s1.compareTo(s2)
	// Used ClassName::InstanceMethod
	final BiFunction<String, String, Integer> biFunctionCompare = String::compareTo;
	final BiFunction<String, String, Integer> biFunctionCompare1 = (s1, s2) -> s1.compareTo(s2);

	// D. (Integer x,Integer y) -> Math.pow(x,y)
	// Used ClassName:StaticMethod
	final BiFunction<Integer, Integer, Double> powerFunction = (x, y) -> Math.pow(x, y);
	final BiFunction<Integer, Integer, Double> powerFunction1 = Math::pow;

	// E. (Apple a) -> a.getWeight()
	// Used ClassName::InstanceMethod
	final Function<Apple, Double> apple = Apple::getWeight;

	// F. EmployeeNameComparator comp = new EmployeeNameComparator();
	// (Employee e1, Employee e2) -> comp.compare(e1,e2)
	// Used instance::InstanceMethod
	EmployeeNameComparator comp = new EmployeeNameComparator();
	final BiFunction<Employee, Employee, Integer> employeeComparator = comp::compare;

	public static void main(String[] args) {
		new Examples().evaluator();
	}

	void evaluator() {

		Employee meresa = new Employee("Meresa", 10000);
		Employee aregawi = new Employee("Aregawi", 60000);
		Apple a = new Apple(4.5);

		// A) Apply getEmployee Name
		System.out.println(getEmployeeName.apply(meresa));

		// B) Set employee Name
		setEmployeeName.accept(meresa, "Meresa");
		System.out.println(aregawi.getName());

		// C) Compare names
		System.out.println(
				"Meresa and Aregawi are now Equal ? " + (biFunctionCompare.apply(meresa.getName(), aregawi.getName()) == 0));

		// D) Power function
		System.out.println("2 ^ 4 = " + powerFunction.apply(2, 4));

		// E) Get apple weight
		System.out.println("Your apple weighs  " + apple.apply(a));
		;

		// F) Compare employees
		System.out.println("E1 and E2 are equal ? " + (employeeComparator.apply(meresa, aregawi) == 0));

	}

}
