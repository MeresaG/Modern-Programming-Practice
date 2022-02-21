package lesson3.prob3.b;

public class Cylinder {

	private double height;
	private Circle baseCircle;

	public Cylinder(double radius, double height) {

		this.baseCircle = new Circle(radius);
		this.height = height;

	}

	public double getHeight() {
		return height;
	}

	public double getRadius() {
		return baseCircle.getRadius();
	}

	public double computeVolume() {

		return Math.PI * getRadius() * getRadius() * height;
	}

}
