package structural;

//Component interface
interface Cake {
	String getDescription();

	double cost();
}

//Concrete component class
class SimpleCake implements Cake {
	@Override
	public String getDescription() {
		return "Simple Cake";
	}

	@Override
	public double cost() {
		return 10.0;
	}
}

//Decorator abstract class
abstract class CakeDecorator implements Cake {
	protected Cake cake;

	public CakeDecorator(Cake cake) {
		this.cake = cake;
	}

	@Override
	public String getDescription() {
		return cake.getDescription();
	}

	@Override
	public double cost() {
		return cake.cost();
	}
}

//Concrete decorator classes
class ChocolateDecorator extends CakeDecorator {
	public ChocolateDecorator(Cake cake) {
		super(cake);
	}

	@Override
	public String getDescription() {
		return cake.getDescription() + ", Chocolate";
	}

	@Override
	public double cost() {
		return cake.cost() + 5.0; // Adding the cost of chocolate
	}
}

class SprinklesDecorator extends CakeDecorator {
	public SprinklesDecorator(Cake cake) {
		super(cake);
	}

	@Override
	public String getDescription() {
		return cake.getDescription() + ", Sprinkles";
	}

	@Override
	public double cost() {
		return cake.cost() + 3.0; // Adding the cost of sprinkles
	}
}

public class DecoratorPatternExample {
	
	public static void main(String[] args) {
		// Create a simple cake
		Cake simpleCake = new SimpleCake();
		System.out.println("Description: " + simpleCake.getDescription());
		System.out.println("Cost: $" + simpleCake.cost());

		// Decorate the simple cake with chocolate
		Cake chocolateCake = new ChocolateDecorator(simpleCake);
		System.out.println("\nDescription: " + chocolateCake.getDescription());
		System.out.println("Cost: $" + chocolateCake.cost());

		// Decorate the simple cake with sprinkles
		Cake sprinklesCake = new SprinklesDecorator(simpleCake);
		System.out.println("\nDescription: " + sprinklesCake.getDescription());
		System.out.println("Cost: $" + sprinklesCake.cost());

		// Decorate the simple cake with both chocolate and sprinkles
		Cake chocolateSprinklesCake = new SprinklesDecorator(new ChocolateDecorator(simpleCake));
		System.out.println("\nDescription: " + chocolateSprinklesCake.getDescription());
		System.out.println("Cost: $" + chocolateSprinklesCake.cost());
	}
}
