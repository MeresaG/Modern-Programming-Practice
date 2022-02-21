package lesson5.prob2;

public final class Rectangele implements ClosedCurve{
	
	private final double width;
	private final double height;
	
	public Rectangele(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	
	@Override
	public double computeArea() {
		
		return width * height;
		
	}
	
	
	
	
	

}
