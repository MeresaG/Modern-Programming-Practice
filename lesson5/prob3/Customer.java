package lesson5.prob3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Order> orders;

	//package level
	Customer(String name) {
		this.name = name;
		orders = new ArrayList<Order>();
	}

	//package level
	void addOrder(LocalDate orderDate) {
		orders.add(new Order(orderDate));
	}

	public String getName() {
		return name;
	}

	public List<Order> getOrders() {
		return orders;
	}
}
