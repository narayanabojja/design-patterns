package behavioural;

import java.util.ArrayList;
import java.util.List;

//Define an interface for the Iterator
interface Iterator {
	boolean hasNext();

	Object next();
}

//Concrete implementation of the Iterator interface for iterating over a collection
class ConcreteIterator implements Iterator {
	private int index = 0;
	private List<Object> collection;

	public ConcreteIterator(List<Object> collection) {
		this.collection = collection;
	}

	@Override
	public boolean hasNext() {
		return index < collection.size();
	}

	@Override
	public Object next() {
		if (this.hasNext()) {
			return collection.get(index++);
		}
		return null;
	}
}

//Aggregate interface providing a method to create an Iterator
interface Aggregate {
	Iterator createIterator();
}

//Concrete implementation of the Aggregate interface
class ConcreteAggregate implements Aggregate {
	private List<Object> collection = new ArrayList<>();

	public void add(Object element) {
		collection.add(element);
	}

	@Override
	public Iterator createIterator() {
		return new ConcreteIterator(collection);
	}
}

public class IteratorPatternExample {

	public static void main(String[] args) {
		ConcreteAggregate aggregate = new ConcreteAggregate();
		aggregate.add("Item 1");
		aggregate.add("Item 2");
		aggregate.add("Item 3");

		// Create an iterator for the collection
		Iterator iterator = aggregate.createIterator();

		// Traverse and print elements using the iterator
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
