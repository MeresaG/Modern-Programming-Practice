package lesson8.prob2.a;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {

		if (e1.salary != e2.salary) {
			if (e1.salary > e2.salary)
				return 1;
			return -1;
		}
		return e1.name.compareTo(e2.name);
	}
}
