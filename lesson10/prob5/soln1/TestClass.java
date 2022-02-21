package testProject.prob5.soln1;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import testProject.prob5.Employee;
import testProject.prob5.Main;

public class TestClass {

	@Test
	public void testAsString() throws Exception{
		Main main = new Main();
		List<Employee> employee = new ArrayList<Employee>();
		employee.addAll(List.of(
				new Employee("Joe", "Davis", 120000),
		        new Employee("John", "Sims", 110000),
		        new Employee("Joe", "Stevens", 200000),
                new Employee("Andrew", "Reardon", 80000),
                new Employee("Joe", "Cummings", 760000),
                new Employee("Steven", "Walters", 135000),
                new Employee("Thomas", "Blake", 111000),
                new Employee("Alice", "Richards", 101000),
                new Employee("Donald", "Trump", 100000)
		));
		
		String expeted = "Alice Richards, Joe Stevens, John Sims, Steven Walters";
		
		assertEquals(main.asString(employee), expeted);
		
	}

}
