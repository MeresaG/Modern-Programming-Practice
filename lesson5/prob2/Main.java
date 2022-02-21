package lesson5.prob2;

public class Main {

	public static void main(String[] args) {
		
		ClosedCurve[] shapes = {new Circle(3.4), new Rectangele(10, 12), new Triangle(4, 7)};
		
		double sum = 0;
		
		for(ClosedCurve f : shapes) {
			
			sum += f.computeArea();
			
		}
		
		System.out.println("Sum of Areas = " +sum);

	}

}
