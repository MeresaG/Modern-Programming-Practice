package lesson4;

public abstract class Employee {
	
	private int empId;
	
	public abstract double calcGrossPay(int month, int year);
	
	public Employee(int empId) {
		super();
		this.empId = empId;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Paycheck calcCompensation(int month, int year) {
		
		double grossPay = calcGrossPay(month, year);
		
		return new Paycheck(grossPay, 23, 5, 1, 3, 7.5);
		
	}


}
