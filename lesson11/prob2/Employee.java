package lesson11.prob2;

class Employee {
	// instance fields
	private double salary;
	private String name;

	// constructor
	Employee(String aName, double aSalary) {
		salary = aSalary;
		name = aName;
	}

	// instance methods
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return name + ":" + salary;
	}

}