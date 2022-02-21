package lesson5.prob3.main;

import java.time.LocalDate;

import lesson5.prob3.CustOrderFactory;
import lesson5.prob3.Customer;
import lesson5.prob3.CustomerOrder;
import lesson5.prob3.Order;

public class Main {
	public static void main(String[] args) {
		
		CustOrderFactory custFact =  new CustOrderFactory();
		CustomerOrder custOrder = custFact.createCustomerOrder("Bob");
		
		custOrder.addOrder(LocalDate.now());
		custOrder.addItem(custOrder.getCustomer().getOrders().get(0), "Shirt");
		custOrder.addItem(custOrder.getCustomer().getOrders().get(0), "Laptop");
		
		custOrder.addOrder(LocalDate.now());
		custOrder.addItem(custOrder.getCustomer().getOrders().get(1), "Pants");
		custOrder.addItem(custOrder.getCustomer().getOrders().get(1), "Knife set");

        // Display Orders
        System.out.println( custOrder.getCustomer().getOrders().toString());
		
	}
}
