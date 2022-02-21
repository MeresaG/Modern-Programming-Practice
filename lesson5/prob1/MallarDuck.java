package lesson5.prob1;

public class MallarDuck extends Duck{
	
	MallarDuck() {
		
		setFlyBehavior(new FlyWithWings());
		setQuackBehavior(new Quack());
		
	}
	
	@Override
	public void display() {
		System.out.println("    display");
	}

}
