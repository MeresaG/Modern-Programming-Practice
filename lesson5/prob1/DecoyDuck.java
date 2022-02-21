package lesson5.prob1;

public class DecoyDuck extends Duck{
	
	 DecoyDuck() {
		setFlyBehavior(new CannotFly());
		setQuackBehavior(new MuteQuack());
	}
	
	@Override
	public void display() {
		System.out.println("    displaying");
	}

}
