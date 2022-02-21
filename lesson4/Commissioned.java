package lesson4;

import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee {

	private double commission;
	private double baseSalary;
	public List<Order> orders;

	public Commissioned(int empId, double commission, double baseSalary) {
		super(empId);
		this.commission = commission;
		this.baseSalary = baseSalary;
		this.orders = new ArrayList<Order>();
	}

	public void addOrder(Order o) {
		orders.add(o);
	}

	@Override
	public double calcGrossPay(int month, int year) {

		double totalOrdersThisMonth = 0;
		for (Order order : orders) {
			if (month == order.getOrderDate().getMonthValue() && year == order.getOrderDate().getYear())
				totalOrdersThisMonth += order.getOrderAmount();
		}
		return baseSalary + totalOrdersThisMonth * commission;

	}

}
