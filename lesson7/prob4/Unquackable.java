package lesson7.prob4;

public interface Unquackable extends Quackable {
	
	default void quack() {
		System.out.println("  cannot quack");
	}
	
}
