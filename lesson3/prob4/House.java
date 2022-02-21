package lesson3.prob4;

public class House extends Property {
	
	private double iotSize;
	
	public House(double iotSize) {
		
		this.iotSize = iotSize;
		
	}
	
	public double computeRent() {
		
		return 0.1 * iotSize;
		
	}

}
