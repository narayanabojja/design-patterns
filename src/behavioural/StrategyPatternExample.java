package behavioural;

/**
 * Strategy pattern is used when we have multiple algorithms for a specific
 * task, and the client decides the actual implementation to be used at runtime.
 * A strategy pattern is also known as a policy pattern. We define multiple
 * algorithms and let client applications pass the algorithm to be used as a
 * parameter.
 */

//Strategy interface
interface PaymentStrategy {
	void processPayment(int amount);
}

//Concrete Strategy: Credit Card
class CreditCardPayment implements PaymentStrategy {

	@Override
	public void processPayment(int amount) {
		System.out.println("Making " + amount + " payment via Credit Card");
	}
}

//Concrete Strategy: Debit Card
class DebitCardPayment implements PaymentStrategy {

	@Override
	public void processPayment(int amount) {
		System.out.println("Making " + amount + "  payment via Debit Card");
	}
}

//Concrete Strategy: UPI
class UPIPayment implements PaymentStrategy {

	@Override
	public void processPayment(int amount) {
		System.out.println("Making  " + amount + "  payment via UPI");
	}
}

//Context
class ShoppingCart {
	private PaymentStrategy paymentStrategy;

	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public void checkout(int amount) {
		paymentStrategy.processPayment(amount);// Polymorphic Behaviour
	}
}

//Example usage
public class StrategyPatternExample {
	public static void main(String[] args) {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setPaymentStrategy(new CreditCardPayment());
		shoppingCart.checkout(10);
		shoppingCart.setPaymentStrategy(new DebitCardPayment());
		shoppingCart.checkout(20);
		shoppingCart.setPaymentStrategy(new UPIPayment());
		shoppingCart.checkout(30);
	}
}
