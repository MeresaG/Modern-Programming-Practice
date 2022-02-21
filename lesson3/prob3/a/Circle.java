package lesson3.prob3.a;

public class Circle extends Cylinder{
	
	
	public Circle(double radius) {
		super(radius, 0.0);
		
	}
	
	public double getRadius() {
		return super.getRadius();
	}
	
	public double computeArea() {
		
		return Math.PI * super.getRadius() * super.getRadius();
		
	}

}
