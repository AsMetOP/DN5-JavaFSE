public class ForecastTest {
    public static void main(String[] args) {
        double present = 10000;
        double rate = 0.08;
        int years = 5;

        double result = ForecastUtil.futureValue(present, rate, years);
        System.out.println("Present Value: " + present);
        System.out.println("Growth Rate: " + (rate * 100) + "%");
        System.out.println("Years: " + years);
        System.out.println("Future Value: " + Math.round(result * 100.0) / 100.0);
    }
}