package structural;

import java.util.ArrayList;
import java.util.List;

/**
 * The Composite Pattern is a structural design pattern that allows you to
 * compose objects into tree structures to represent part-whole hierarchies. It
 * lets clients treat individual objects and compositions of objects uniformly.
 * 
 * In Java, the Composite Pattern is useful when you have a hierarchy of objects
 * and you want to treat individual objects and groups of objects in the same
 * way.
 */
// Component interface
interface Component {
	void operation();
}

// Leaf class
class Leaf implements Component {
	private String name;

	public Leaf(String name) {
		this.name = name;
	}

	@Override
	public void operation() {
		System.out.println("Leaf " + name + " operation");
	}
}

// Composite class
class Composite implements Component {
	
	private List<Component> children = new ArrayList<>();

	public void add(Component component) {
		children.add(component);
	}

	public void remove(Component component) {
		children.remove(component);
	}

	@Override
	public void operation() {
		System.out.println("Composite operation:");
		for (Component component : children) {
			component.operation();
		}
	}
}

public class CompositePatternExample {

	public static void main(String[] args) {
		// Create leaf components
		Leaf leaf1 = new Leaf("Leaf 1");
		Leaf leaf2 = new Leaf("Leaf 2");
		Leaf leaf3 = new Leaf("Leaf 3");

		// Create composite components
		Composite composite1 = new Composite();
		Composite composite2 = new Composite();

		// Add leaf components to composite1
		composite1.add(leaf1);
		composite1.add(leaf2);

		// Add leaf and composite components to composite2
		composite2.add(leaf3);
		composite2.add(composite1);

		// Call operation on composite2, which recursively calls operation on all its
		// children
		composite2.operation();
	}
}
