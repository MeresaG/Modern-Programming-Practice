package lesson3.prob1;

/*
 * Implementation of PersonWithJob using Compostion instead of Inheritance.
 *  Now we can't use PersonWithJob in context of polymorphism, but it can
 *  support a different equals implementation.
 */

public class PersonWithJob {
	
	private Person person;
	private double salary;

	public double getSalary() {
		return salary;
	}

	PersonWithJob(String n, double s) {
		person =  new Person(n);
		salary = s;
	}

	@Override
	public boolean equals(Object aPerson) {
		if (aPerson == null)
			return false;
		if (aPerson.getClass() != this.getClass())
			return false;
		PersonWithJob p = (PersonWithJob) aPerson;
		boolean isEqual = this.person.getName().equals(p.person.getName()) && this.getSalary() == p.getSalary();
		return isEqual;
	}

	public static void main(String[] args) {
		PersonWithJob p1 = new PersonWithJob("Joe", 30000);
		Person p2 = new Person("Joe");
		// As PersonsWithJobs, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}

}
