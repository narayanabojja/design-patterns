package structural;

/**
 * The Proxy Design Pattern is a structural design pattern that provides a
 * surrogate or placeholder for another object to control access to it. This
 * allows you to add an extra level of indirection and control over how, when,
 * and where the original object is accessed. Proxy objects are commonly used
 * for lazy initialization, access control, logging, monitoring, caching, and
 * more.
 */
//Interface representing Internet access
interface Internet {
	void browse(String website);
}

//Real subject implementing Internet interface
class RealInternet implements Internet {
	@Override
	public void browse(String website) {
		System.out.println("Browsing " + website);
	}
}

//Proxy class implementing Internet interface
class InternetProxy implements Internet {
	private Internet internet = new RealInternet();
	private int userAge;

	InternetProxy(int userAge) {
		this.userAge = userAge;
	}

	@Override
	public void browse(String website) {
		if (userAge < 18 && website.equals("adult-site.com")) {
			System.out.println("Access denied. You are under 18.");
		} else {
			internet.browse(website);
		}
	}
}

public class ProxyDesignPatternExample {

	public static void main(String[] args) {
		// Create an internet proxy for a user with age 16
		Internet internet = new InternetProxy(16);

		// Try to browse various websites
		internet.browse("google.com"); // Allowed
		internet.browse("adult-site.com"); // Denied
	}
}
