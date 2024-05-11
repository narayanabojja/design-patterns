package creational;

/**
 * The Singleton Pattern is a design pattern that restricts the instantiation of
 * a class to one object. This means that only one instance of the class can
 * exist in the entire application, providing a global point of access to that
 * instance. It's useful when exactly one object is needed to coordinate actions
 * across the system, such as a database connection, a logger, or a
 * configuration manager.
 */
class Singleton {
	// Private static variable to hold the single instance of the class
	private static Singleton instance;

	// Private constructor to prevent instantiation from outside
	private Singleton() {
		// Constructor implementation goes here
	}

	// Public static method to get the single instance of the class
	public static Singleton getInstance() {
		// If the instance is not created yet, create it
		if (instance == null) {
			instance = new Singleton();
		}
		// Return the single instance
		return instance;
	}

	// Other methods and variables can be added here
}

class EagerInitializedSingleton {
	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

	// Private constructor to prevent instantiation from outside
	private EagerInitializedSingleton() {
	}

	public static EagerInitializedSingleton getInstance() {
		return instance;
	}
}

class LazyInitializedSingleton {
	private static LazyInitializedSingleton instance;

	private LazyInitializedSingleton() {
	}

	public static synchronized LazyInitializedSingleton getInstance() {
		if (instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}
}

class DoubleCheckedLockingSingleton {
	private static volatile DoubleCheckedLockingSingleton instance;

	private DoubleCheckedLockingSingleton() {
	}

	public static DoubleCheckedLockingSingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckedLockingSingleton.class) {
				if (instance == null) {
					instance = new DoubleCheckedLockingSingleton();
				}
			}
		}
		return instance;
	}
}

class BillPughSingleton {
	private BillPughSingleton() {
	}

	private static class SingletonHelper {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}

	public static BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}

enum EnumSingleton {
	INSTANCE;

	// Add methods and variables here
}

public class SingletonDesignPatternExample {
	public static void main(String[] args) {
		Singleton singletonInstance1 = Singleton.getInstance();
		Singleton singletonInstance2 = Singleton.getInstance();

		// Check if both instances are the same
		System.out.println(singletonInstance1 == singletonInstance2);
	}
}
