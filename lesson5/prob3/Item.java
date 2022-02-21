package lesson5.prob3;

public class Item {
	String name;

	//package level
	Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
