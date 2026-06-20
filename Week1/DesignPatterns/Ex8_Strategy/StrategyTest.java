public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment("4521-9988-8788"));
        context.executeStrategy(2500);

        context.setStrategy(new PayPalPayment("okasmet@gmail.com"));
        context.executeStrategy(800);
    }
}