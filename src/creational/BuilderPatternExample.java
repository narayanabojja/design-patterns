package creational;

/**
 * The Builder Pattern is a creational design pattern used to construct complex
 * objects step by step. It separates the construction of a complex object from
 * its representation, allowing the same construction process to create
 * different representations.
 * In Java, the Builder Pattern is commonly used when a class has a large number
 * of constructor parameters or when there are multiple ways to construct an
 * object with different combinations of parameters.
 * 
 */
//House class
class House {
	private int floors;
	private int bedrooms;
	private int bathrooms;
	private boolean hasGarage;
	private boolean hasSwimmingPool;

	public House(int floors, int bedrooms, int bathrooms, boolean hasGarage, boolean hasSwimmingPool) {
		this.floors = floors;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.hasGarage = hasGarage;
		this.hasSwimmingPool = hasSwimmingPool;
	}

	@Override
	public String toString() {
		return "House{" + "floors=" + floors + ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms + ", hasGarage="
				+ hasGarage + ", hasSwimmingPool=" + hasSwimmingPool + '}';
	}
}

//Builder interface
interface HouseBuilder {
	HouseBuilder setFloors(int floors);

	HouseBuilder setBedrooms(int bedrooms);

	HouseBuilder setBathrooms(int bathrooms);

	HouseBuilder setHasGarage(boolean hasGarage);

	HouseBuilder setHasSwimmingPool(boolean hasSwimmingPool);

	House build();
}

//Concrete builder implementation
class ConcreteHouseBuilder implements HouseBuilder {
	private int floors;
	private int bedrooms;
	private int bathrooms;
	private boolean hasGarage;
	private boolean hasSwimmingPool;

	@Override
	public HouseBuilder setFloors(int floors) {
		this.floors = floors;
		return this;
	}

	@Override
	public HouseBuilder setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
		return this;
	}

	@Override
	public HouseBuilder setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
		return this;
	}

	@Override
	public HouseBuilder setHasGarage(boolean hasGarage) {
		this.hasGarage = hasGarage;
		return this;
	}

	@Override
	public HouseBuilder setHasSwimmingPool(boolean hasSwimmingPool) {
		this.hasSwimmingPool = hasSwimmingPool;
		return this;
	}

	@Override
	public House build() {
		return new House(floors, bedrooms, bathrooms, hasGarage, hasSwimmingPool);
	}
}

//Director class (optional)
class HouseDirector {
	private HouseBuilder builder;

	public HouseDirector(HouseBuilder builder) {
		this.builder = builder;
	}

	public House construct() {
		return builder.setFloors(2).setBedrooms(3).setBathrooms(2).setHasGarage(true).setHasSwimmingPool(false).build();
	}
}

public class BuilderPatternExample {

	public static void main(String[] args) {
		// Create a concrete builder
		HouseBuilder builder = new ConcreteHouseBuilder();

		// Create a house using the builder
		House house = builder.setFloors(2).setBedrooms(4).setBathrooms(3).setHasGarage(true).setHasSwimmingPool(true)
				.build();

		// Print the house details
		System.out.println(house);

		// Alternatively, you can use a director
		/*
		 * HouseDirector director = new HouseDirector(builder); House house2 =
		 * director.construct(); System.out.println(house2);
		 */
	}
}
