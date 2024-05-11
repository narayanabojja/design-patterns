package behavioural;

/**
 * The Template Method Design Pattern is a behavioral design pattern that
 * defines the skeleton of an algorithm in the superclass but lets subclasses
 * override specific steps of the algorithm without changing its structure. It
 * follows the "Hollywood Principle" - "Don't call us, we'll call you", meaning
 * the high-level component (template method) calls the low-level components
 * (methods to be overridden), not vice versa. This pattern promotes code
 * reusability and flexibility by allowing subclasses to customize certain parts
 * of an algorithm without changing its overall structure.
 */
abstract class Pizza {
	// Template method
	public final void makePizza() {
		prepareDough();
		addSauce();
		addToppings();
		bakePizza();
		if (customerWantsExtraCheese()) {
			addExtraCheese();
		}
	}

	// Abstract methods to be implemented by subclasses
	abstract void prepareDough();

	abstract void addSauce();

	abstract void addToppings();

	abstract void bakePizza();

	// Hook method (optional step that subclasses can override)
	boolean customerWantsExtraCheese() {
		return false;
	}

	// Common method
	void addExtraCheese() {
		System.out.println("Adding extra cheese...");
	}
}

class VegPizza extends Pizza {
	@Override
	void prepareDough() {
		System.out.println("Preparing veggie dough...");
	}

	@Override
	void addSauce() {
		System.out.println("Adding tomato sauce...");
	}

	@Override
	void addToppings() {
		System.out.println("Adding vegetables...");
	}

	@Override
	void bakePizza() {
		System.out.println("Baking at 200°C for 15 minutes...");
	}

	// Overriding hook method
	@Override
	boolean customerWantsExtraCheese() {
		return true;
	}
}

class NonVegPizza extends Pizza {
	@Override
	void prepareDough() {
		System.out.println("Preparing non-veg dough...");
	}

	@Override
	void addSauce() {
		System.out.println("Adding BBQ sauce...");
	}

	@Override
	void addToppings() {
		System.out.println("Adding meat toppings...");
	}

	@Override
	void bakePizza() {
		System.out.println("Baking at 220°C for 20 minutes...");
	}
}

public class TemplateMethodPatternExample {
	public static void main(String[] args) {
		System.out.println("Preparing Veg Pizza:");
		Pizza vegPizza = new VegPizza();
		vegPizza.makePizza();

		System.out.println("\nPreparing Non-Veg Pizza:");
		Pizza nonVegPizza = new NonVegPizza();
		nonVegPizza.makePizza();
	}
}
