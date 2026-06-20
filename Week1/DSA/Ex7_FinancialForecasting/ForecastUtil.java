public class ForecastUtil {
    public static double futureValue(double value, double growthRate, int years) {
        if (years == 0) return value;
        return futureValue(value * (1 + growthRate), growthRate, years - 1);
    }
}