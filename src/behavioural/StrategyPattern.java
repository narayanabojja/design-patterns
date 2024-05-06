package behavioural;

//Strategy interface
interface PaymentStrategy {
	void pay(int amount);
}

//Concrete strategy: Credit Card payment
class CreditCardPayment implements PaymentStrategy {
	private String cardNumber;
	private String expirationDate;
	private String cvv;

	public CreditCardPayment(String cardNumber, String expirationDate, String cvv) {
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
	}

	@Override
	public void pay(int amount) {
		System.out.println("Paid " + amount + " using Credit Card.");
		// Additional logic for processing credit card payment
	}
}

//Concrete strategy: PayPal payment
class PayPalPayment implements PaymentStrategy {
	private String email;
	private String password;

	public PayPalPayment(String email, String password) {
		this.email = email;
		this.password = password;
	}

	@Override
	public void pay(int amount) {
		System.out.println("Paid " + amount + " using PayPal.");
		// Additional logic for processing PayPal payment
	}
}

//Context
class ShoppingCart {
	private PaymentStrategy paymentStrategy;

	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public void checkout(int amount) {
		paymentStrategy.pay(amount);
	}
}

//Example usage
public class StrategyPattern {
	public static void main(String[] args) {
		// Create a shopping cart
		ShoppingCart cart = new ShoppingCart();

		// Set payment strategy to credit card
		cart.setPaymentStrategy(new CreditCardPayment("1234 5678 9012 3456", "12/24", "123"));

		// Perform checkout
		cart.checkout(100);

		// Change payment strategy to PayPal
		cart.setPaymentStrategy(new PayPalPayment("example@example.com", "password"));

		// Perform checkout with PayPal
		cart.checkout(200);
	}
}
