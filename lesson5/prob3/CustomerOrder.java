package lesson5.prob3;

import java.time.LocalDate;

public interface CustomerOrder {
	
	public Customer getCustomer();
	public void addOrder(LocalDate orderDate);
	public void addItem(Order order, String name);

}
