package lesson5.prob1;

public class RubberDuck extends Duck{
	
	RubberDuck() {
		
		
		setFlyBehavior(new CannotFly());
		setQuackBehavior(new Squeak());
		
	}
	
	@Override
	public void display() {
		System.out.println("    displaying");
	}

}
