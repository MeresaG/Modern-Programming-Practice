package lesson2.prob2B;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private int orderNum;
	private List<OrderLine> orderlines;
	
	public Order(int orderNum) {
		
		this.orderNum = orderNum;
		orderlines = new ArrayList<OrderLine>();
		orderlines.add(new OrderLine(this));
		
	}
	
	public OrderLine addOrderLine() {
		
		OrderLine orderLine =  new OrderLine(this);
		orderlines.add(orderLine);
		return orderLine;
		
	}
	
	public int getOrderNum() {
		return orderNum;
	}
	
	public List<OrderLine> getOrderLines() {
		
		return orderlines;
	}

	
	@Override
	public String toString() {
		return "Order Object!";
	}
}
