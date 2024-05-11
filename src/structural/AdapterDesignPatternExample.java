package structural;

/**
 * The Adapter Design Pattern is a structural design pattern that allows
 * incompatible interfaces to work together. It acts as a bridge between two
 * incompatible interfaces by providing a wrapper class that implements the
 * interface expected by the client and delegates the calls to the adaptee,
 * which has the interface that needs to be adapted. This pattern is useful when
 * you want to reuse existing classes but their interfaces are not compatible
 * with the interface required by the client.
 */
//Adaptee interface (existing interface)
interface TemperatureProvider {
	double getTemperatureCelsius();
}

//Adaptee (existing class)
class CelciusTemperatureProvider implements TemperatureProvider {
	@Override
	public double getTemperatureCelsius() {
		// Logic to get temperature in Celsius
		return 25.0;
	}
}

//Target interface (expected by the client)
interface FahrenheitTemperatureProvider {
	double getTemperatureFahrenheit();
}

//Adapter
class TemperatureAdapter implements FahrenheitTemperatureProvider {
	private TemperatureProvider celciusTemperatureProvider;

	public TemperatureAdapter(TemperatureProvider celciusTemperatureProvider) {
		this.celciusTemperatureProvider = celciusTemperatureProvider;
	}

	@Override
	public double getTemperatureFahrenheit() {
		// Convert Celsius to Fahrenheit
		double celsius = celciusTemperatureProvider.getTemperatureCelsius();
		double fahrenheit = (celsius * 9 / 5) + 32;
		return fahrenheit;
	}
}

//Client code
public class AdapterDesignPatternExample {
	public static void main(String[] args) {
		TemperatureProvider celciusTemperatureProvider = new CelciusTemperatureProvider();
		FahrenheitTemperatureProvider adapter = new TemperatureAdapter(celciusTemperatureProvider);

		// Now the client code can get the temperature in Fahrenheit
		double temperatureFahrenheit = adapter.getTemperatureFahrenheit();
		System.out.println("Temperature in Fahrenheit: " + temperatureFahrenheit);
	}
}
