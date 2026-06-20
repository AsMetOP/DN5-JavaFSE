public class ObserverTest {
    public static void main(String[] args) {
        StockMarket tcsStock = new StockMarket("TCS");

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        tcsStock.registerObserver(mobile);
        tcsStock.registerObserver(web);

        tcsStock.setPrice(3450.50);
        tcsStock.setPrice(3475.25);

        tcsStock.removeObserver(web);
        tcsStock.setPrice(3500.00);
    }
}