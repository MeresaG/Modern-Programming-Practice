package lesson7.prob4;

public interface Flyable {
	
	default void fly() {
		System.out.println("  flying");
	}
	
}
