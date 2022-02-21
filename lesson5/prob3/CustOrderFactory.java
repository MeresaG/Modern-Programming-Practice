package lesson5.prob3;

import java.time.LocalDate;

public class CustOrderFactory {
	
	public CustOrderFactory() {};
	
	public static CustomerOrder createCustomerOrder(String name) {
		
		Customer cust = new Customer(name);
		
		return new CustomerOrderImpl(cust);
	
	}
	
	}
