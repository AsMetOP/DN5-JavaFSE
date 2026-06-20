public class PaytmAdapter implements PaymentProcessor {
    private PaytmGateway gateway;

    public PaytmAdapter(PaytmGateway gateway) {
        this.gateway = gateway;
    }

    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}