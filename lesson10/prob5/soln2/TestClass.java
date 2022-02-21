package testProject.prob5.soln2;

import static org.junit.Assert.*;
import org.junit.Test;
import testProject.prob5.Employee;
import testProject.prob5.Main;

public class TestClass {

	Employee employee=  new Employee("Johnathan", "Santiago", 150000);
	Main main= new Main();
	

	@Test
	public void testLastNameAfterM() {
		assertEquals(main.lastNameAfterM(employee), true);
	}

	@Test
	public void testFullName() {
		assertEquals(main.fullName(employee), "Johnathan Santiago");
	}

	@Test
	public void testSalaryGreaterThan100000() {
		
		assertEquals(main.salaryGreaterThan100000(employee), true);
	}

}
