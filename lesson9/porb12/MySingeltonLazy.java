package lesson9.porb12;

import java.util.Optional;

public class MySingeltonLazy {

	private static MySingeltonLazy instance = null;

	private MySingeltonLazy() {
	}

	private static MySingeltonLazy createInstance() {
		instance = new MySingeltonLazy();
		return instance;

	}

	public static MySingeltonLazy getInstance() {

		/*
		 * if(instance == null) return new MySingeltonLazy(); else return instance;
		 */

		return Optional.ofNullable(instance).orElseGet(MySingeltonLazy::createInstance);

	}

	public static void main(String[] args) {

		MySingeltonLazy s1 = MySingeltonLazy.getInstance();
		MySingeltonLazy s2 = MySingeltonLazy.getInstance();

		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());

	}

}
