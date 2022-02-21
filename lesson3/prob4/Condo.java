package lesson3.prob4;

public class Condo extends Property{

	private int numFloor;
	
	public Condo(int numFloor) {
		this.numFloor = numFloor;
	}
	
	public double computeRent() {
		
		return 400 * numFloor;
		
	}
	
}
