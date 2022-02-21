package lesson7.prob4;

public interface Quackable {
	
	default void quack() {
		System.out.println("  quacking");
	}
	
}
