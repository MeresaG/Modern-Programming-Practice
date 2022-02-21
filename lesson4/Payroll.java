package lesson4;

import java.time.LocalDate;

public class Payroll {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2021, 9, 25);
		Order o = new Order(3, date, 20);
		
		Commissioned c = new Commissioned(3, 50, 4000);
		c.addOrder(o);
		
		Employee[] emp  = { 
				
				new Hourly(1, 200, 40),
				new Salaried(2, 8000),
				c
				
		};
		
		double payCheck = 0;
		Paycheck p ;
		for (Employee e : emp) {
			p = e.calcCompensation(9, 2021);
			payCheck += p.getNetPay();
			p.print();
		}
		
		System.out.println("The total paycheck of all employess is = " + payCheck);

	}

}
