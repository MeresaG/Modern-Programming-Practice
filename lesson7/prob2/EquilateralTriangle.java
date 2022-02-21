package lesson7.prob2;

public class EquilateralTriangle implements Polygon{
	
	private double side;
	
	public EquilateralTriangle(double side) {
		this.side = side;
	}

	
	@Override 
	public double[] getSides() {
		
		return new double[] {side, side, side};
	}

}
