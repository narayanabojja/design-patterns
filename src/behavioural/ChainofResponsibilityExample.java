package behavioural;

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
