public class MobileApp implements Observer {
    public void update(String stockName, double price) {
        System.out.println("Mobile app: " + stockName + " is now Rs." + price);
    }
}