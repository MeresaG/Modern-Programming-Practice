package lesson4;

public class Salaried extends Employee{

	private double salary;

	public Salaried(int id, double salary) {
		super(id);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public double calcGrossPay(int month, int year) {
		
		return salary;
		
	}
}
