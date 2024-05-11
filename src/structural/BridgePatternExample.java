package structural;

/**
 * The Bridge Design Pattern is a structural design pattern that decouples an
 * abstraction from its implementation so that the two can vary independently.
 * This pattern is particularly useful when you want to avoid a permanent
 * binding between an abstraction and its implementation and when changes in the
 * implementation should not affect clients. It's achieved by having an
 * interface (abstraction) that is implemented by concrete classes, and another
 * interface (implementation) that is also implemented by concrete classes,
 * allowing the two hierarchies to vary independently.
 * 
 */
//Implementor interface
interface Color {
	String fill();
}

//Concrete Implementor
class RedColor implements Color {
	@Override
	public String fill() {
		return "Coloring the shape with Red color";
	}
}

//Concrete Implementor
class BlueColor implements Color {
	@Override
	public String fill() {
		return "Coloring the shape with Blue color";
	}
}

//Abstraction
abstract class Shape {
	protected Color color;

	public Shape(Color color) {
		this.color = color;
	}

	abstract String draw();
}

//Refined Abstraction
class Square extends Shape {
	public Square(Color color) {
		super(color);
	}

	@Override
	String draw() {
		return "Drawing Square. " + color.fill();
	}
}

//Refined Abstraction
class Circle extends Shape {
	public Circle(Color color) {
		super(color);
	}

	@Override
	String draw() {
		return "Drawing Circle. " + color.fill();
	}
}

public class BridgePatternExample {
	public static void main(String[] args) {
		Color red = new RedColor();
		Color blue = new BlueColor();

		Shape redSquare = new Square(red);
		Shape blueCircle = new Circle(blue);

		System.out.println(redSquare.draw());
		System.out.println(blueCircle.draw());
	}
}
