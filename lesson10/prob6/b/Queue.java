package lesson10.prob6.b;

//Show the methods are not threadsafe.
//Then modify so that they are threadsafe.
public class Queue {

	class Node {
		Object value;
		Node next;
	}

	private Node head;
	private Node tail;

	public void add(Object newValue) {
		Node n = new Node();
		if (head == null)
			head = n;
		else
			tail.next = n;
		tail = n;
		tail.value = newValue;
	}

	public Object remove() {
		if (head == null)
			return null;
		Node n = head;
		head = n.next;
		return n.value;
	}

	// This ensures that an entire block of code has a lock
	synchronized public Object addRemove(Object... argsToAdd) {
			for (Object x : argsToAdd)
				add(x);
			return remove();

	}

	public int countElements() {

		int count = 0;
		Node current = head;

		while (current != null) {
			count++;
			current = current.next;
		}

		return count;

	}
}
