public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor paytm = new PaytmAdapter(new PaytmGateway());
        paytm.processPayment(500);

        PaymentProcessor razorpay = new RazorpayAdapter(new RazorpayGateway());
        razorpay.processPayment(1200);
    }
}