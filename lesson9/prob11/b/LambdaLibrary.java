package lesson9.prob11.b;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaLibrary {
	
	public static final Function<List<Employee>, String> myLambdaExpression = 
			(emp) -> emp.stream()
						.filter(e -> (e.getSalary()) > 100000)
				  		.filter(e-> e.getLastName().matches("^[M-Z].*"))
				  		.map(name -> name.getFirstName() + " " + name.getLastName())
				  		.sorted()
				  		.collect(Collectors.joining(", "));

}
