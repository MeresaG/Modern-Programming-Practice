package lesson4;

public class Hourly extends Employee {

	private double hourlyWage;
	private int hoursPerWeek;

	
	public Hourly(int id, double hourlyWage, int hoursPerWeek) {
		super(id);
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
	}
	
	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	
	@Override
	public double calcGrossPay(int month, int year) {
		
		return this.hourlyWage * this.hoursPerWeek * 4;
		
	}

	

}
