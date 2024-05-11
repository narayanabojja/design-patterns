package behavioural;

import java.util.ArrayList;
import java.util.List;

/**
 * The Observer Pattern is a behavioral design pattern where an object, known as
 * the subject, maintains a list of its dependents, called observers, and
 * notifies them of any changes in state. This pattern is useful in scenarios
 * where multiple objects need to be notified of changes in another object's
 * state without tight coupling between them.
 * 
 */
//Observer interface
interface Observer {
	void update(float temperature);
}

//Subject interface
interface Subject {
	void registerObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObservers();
}

//Concrete subject class
class WeatherStation implements Subject {
	private List<Observer> observers;
	private float temperature;

	public WeatherStation() {
		observers = new ArrayList<>();
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(temperature);
		}
	}
}

//Concrete observer classes
class PhoneDisplay implements Observer {
	@Override
	public void update(float temperature) {
		System.out.println("Phone Display: Temperature updated to " + temperature);
	}
}

class TVDisplay implements Observer {
	@Override
	public void update(float temperature) {
		System.out.println("TV Display: Temperature updated to " + temperature);
	}
}

public class ObserverPatternExample {

	public static void main(String[] args) {
		// Create subject
		WeatherStation weatherStation = new WeatherStation();

		// Create observers
		PhoneDisplay phoneDisplay = new PhoneDisplay();
		TVDisplay tvDisplay = new TVDisplay();

		// Register observers
		weatherStation.registerObserver(phoneDisplay);
		weatherStation.registerObserver(tvDisplay);

		// Update temperature
		weatherStation.setTemperature(25.5f);
		// Output:
		// Phone Display: Temperature updated to 25.5
		// TV Display: Temperature updated to 25.5

		// Update temperature again
		weatherStation.setTemperature(30.0f);
		// Output:
		// Phone Display: Temperature updated to 30.0
		// TV Display: Temperature updated to 30.0

		// Remove an observer
		weatherStation.removeObserver(tvDisplay);

		// Update temperature once more
		weatherStation.setTemperature(22.0f);
		// Output:
		// Phone Display: Temperature updated to 22.0
	}

}
