package lesson5.prob2;

public final class Triangle implements ClosedCurve{
	
	private final double base;
	private final double height;
	
	
	public Triangle(double base, double height) {
		super();
		this.base = base;
		this.height = height;
	}
	public double getBase() {
		return base;
	}
	public double getHeight() {
		return height;
	}
	
	@Override
	public double computeArea() {
		return base * height / 2;
	}
	
	

}
