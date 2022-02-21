package lesson5.prob3;

import java.time.LocalDate;

public class CustomerOrderImpl implements CustomerOrder {

	private Customer cust;

	public CustomerOrderImpl(Customer cust) {

		this.cust = cust;

	}

	@Override
	public Customer getCustomer() {

		return cust;
	}

	@Override
	public void addOrder(LocalDate orderDate) {
		this.cust.addOrder(orderDate);
	}

	@Override
	public void addItem(Order order, String name) {
		order.addItem(name);
	}

}
