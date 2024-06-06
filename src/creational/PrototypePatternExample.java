package creational;

/**
 * The Prototype Pattern is a creational design pattern that allows you to
 * create new objects by copying an existing object, known as a prototype. It
 * provides a way to create new objects based on an existing object's structure,
 * thus avoiding the need for subclassing. 
 * In Java, the Prototype Pattern can be implemented by using either the
 * Cloneable interface or by implementing a custom clone method to create copies
 * of objects.
 * 
 */
//Prototype interface
interface Prototype extends Cloneable {
	Prototype clone();
}

//Concrete prototype class
class ConcretePrototype implements Prototype {
	private int id;
	private String name;

	public ConcretePrototype(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Implementing clone method using the Cloneable interface
	@Override
	public Prototype clone() {
		try {
			return (ConcretePrototype) super.clone();
		} catch (CloneNotSupportedException e) {
			// Handle clone not supported exception
			return null;
		}
	}

	@Override
	public String toString() {
		return "ConcretePrototype{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}

public class PrototypePatternExample {

	public static void main(String[] args) {
		// Create a prototype object
		ConcretePrototype prototype = new ConcretePrototype(1, "Prototype");

		// Clone the prototype to create a new object
		ConcretePrototype clone = (ConcretePrototype) prototype.clone();

		// Print the original and cloned objects
		System.out.println("Original Prototype: " + prototype);
		System.out.println("Cloned Object: " + clone);

		// Modify the cloned object
		clone.setName("Cloned Prototype");

		// Print the modified cloned object
		System.out.println("Modified Cloned Object: " + clone);
	}
}
