public class CreditCardPayment implements PaymentStrategy {
    private String cardNo;

    public CreditCardPayment(String cardNo) {
        this.cardNo = cardNo;
    }

    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using credit card " + cardNo);
    }
}