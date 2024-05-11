package creational;

/**
 * The factory design pattern says to define an interface ( A java interface or
 * an abstract class) for creating the object and let the subclasses decide
 * which class to instantiate. The Factory Pattern is a creational design
 * pattern that provides an interface for creating objects in a superclass, but
 * allows subclasses to alter the type of objects that will be created. This
 * pattern promotes loose coupling by abstracting the object creation process
 * and allowing the client code to work with the interface rather than the
 * concrete implementation.
 * 
 */
//Interface for product
interface Vehicle {
	void drive();
}

//Concrete implementations of product
class Car implements Vehicle {
	@Override
	public void drive() {
		System.out.println("Driving a car");
	}
}

class Truck implements Vehicle {
	@Override
	public void drive() {
		System.out.println("Driving a truck");
	}
}

//Factory interface
interface VehicleFactory {
	Vehicle createVehicle();
}

//Concrete factory classes
class CarFactory implements VehicleFactory {
	@Override
	public Vehicle createVehicle() {
		return new Car();
	}
}

class TruckFactory implements VehicleFactory {
	@Override
	public Vehicle createVehicle() {
		return new Truck();
	}
}

public class FactoryPatternExample {

	public static void main(String[] args) {
		// Create car using CarFactory
		VehicleFactory carFactory = new CarFactory();
		Vehicle car = carFactory.createVehicle();
		car.drive();
		// Output: Driving a car

		// Create truck using TruckFactory
		VehicleFactory truckFactory = new TruckFactory();
		Vehicle truck = truckFactory.createVehicle();
		truck.drive();
		// Output: Driving a truck
	}
}
