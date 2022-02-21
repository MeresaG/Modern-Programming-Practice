package lesson2.prob2B;

public class Main {

	public static void main(String[] args) {
		
		int orderNum = 1;
		
		Order order = new Order(orderNum);
		order.addOrderLine();
		
		
		System.out.println(order);
		System.out.println(order.getOrderLines().toString());

	}

}
