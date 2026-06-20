public class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(double amount) {
        strategy.pay(amount);
    }
}