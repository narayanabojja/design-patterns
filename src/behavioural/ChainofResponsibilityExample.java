package behavioural;

/**
 * The Chain of Responsibility design pattern is a behavioral design pattern
 * that allows an object to pass a request along a chain of handlers. Each
 * handler in the chain decides either to process the request or to pass it
 * along the chain to the next handler. How it can used in Spring Boot-based
 * microservices:
 * 
 * We create chain of Filters or Interceptor to 1. Authenticate or authorize
 * user/client 2. Validation of incoming requests 3. Request data sanitization
 * 4. Logging request / response data and headers
 * https://www.geeksforgeeks.org/chain-responsibility-design-pattern/#realworld-analogy-of-the-chain-of-responsibility-design-pattern
 */
//Request class
class Request {
	private final String type;

	public Request(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}

//Handler interface
interface Handler {
	void setNextHandler(Handler nextHandler);

	void handleRequest(Request request);
}

//Concrete handler
class ConcreteHandler implements Handler {
	private Handler nextHandler;

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public void handleRequest(Request request) {
		if (request.getType().equals("Type1")) {
			System.out.println("Handled Type1 request by ConcreteHandler.");
		} else {
			if (nextHandler != null) {
				nextHandler.handleRequest(request);
			} else {
				System.out.println("All handlers failed to handle the request.");
			}
		}
	}
}

public class ChainofResponsibilityExample {
	public static void main(String[] args) {
		Handler handler1 = new ConcreteHandler();
		Handler handler2 = new ConcreteHandler();

		handler1.setNextHandler(handler2);

		// Create a request
		Request request1 = new Request("Type1");
		Request request2 = new Request("Type2");

		// Handle the requests
		handler1.handleRequest(request1); // Output: Handled Type1 request by ConcreteHandler.
		handler1.handleRequest(request2); // Output: All handlers failed to handle the request.
	}
}
