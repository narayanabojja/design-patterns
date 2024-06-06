package structural;

/**
 * The Facade Pattern is a structural design pattern that provides a simplified
 * interface to a complex system of classes, interfaces, or subsystems. It hides
 * the complexities of the underlying system and provides a unified interface to
 * interact with it. This simplifies the usage of the system and decouples the
 * client code from the subsystems, promoting loose coupling and easier
 * maintenance. In Java, the Facade Pattern is commonly used to provide a
 * high-level interface that hides the complexities of interacting with multiple
 * subsystems or classes.
 */
//Complex subsystems
class SubsystemA {
	public void operationA() {
		System.out.println("SubsystemA operation");
	}
}

class SubsystemB {
	public void operationB() {
		System.out.println("SubsystemB operation");
	}
}

class SubsystemC {
	public void operationC() {
		System.out.println("SubsystemC operation");
	}
}

//Facade class providing a simplified interface to the complex subsystems
class Facade {
	private SubsystemA subsystemA;
	private SubsystemB subsystemB;
	private SubsystemC subsystemC;

	public Facade() {
		this.subsystemA = new SubsystemA();
		this.subsystemB = new SubsystemB();
		this.subsystemC = new SubsystemC();
	}

	public void operationFacade() {
		System.out.println("Facade is calling the operations of subsystems:");
		subsystemA.operationA();
		subsystemB.operationB();
		subsystemC.operationC();
	}
}

public class FacadePatternExample {

	public static void main(String[] args) {
		// Client code interacts with the facade instead of the subsystems directly
		Facade facade = new Facade();
		facade.operationFacade();
	}
}
