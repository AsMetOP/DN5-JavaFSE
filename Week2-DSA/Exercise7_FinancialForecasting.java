import java.util.HashMap;
import java.util.Map;

// ─────────────────────────────────────────────
// Exercise 7: Financial Forecasting
// Recursion: O(n) stack depth
// Memoized Fibonacci: O(n) vs plain O(2^n)
// ─────────────────────────────────────────────

public class Exercise7_FinancialForecasting {

    private static Map<Integer, Long> memo = new HashMap<>();

    // Compound future value — recursive
    // fv(p, r, n) = fv(p, r, n-1) * (1 + r)   [base: n==0 → p]
    static double futureValue(double principal, double rate, int years) {
        if (years == 0) return principal;
        return futureValue(principal, rate, years - 1) * (1 + rate);
    }

    // Memoized Fibonacci (growth index model)
    static long fib(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        long result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);
        return result;
    }

    static void printProjection(double principal, double rate, int years) {
        System.out.printf("%-6s %-15s%n", "Year", "Value (₹)");
        System.out.println("─".repeat(22));
        for (int y = 0; y <= years; y++)
            System.out.printf("%-6d %-15.2f%n", y, futureValue(principal, rate, y));
    }

    public static void main(String[] args) {
        double principal = 100_000.0;
        double rate      = 0.12;
        int    years     = 10;

        System.out.println("=== Compound Growth Projection (₹1L @ 12%) ===\n");
        printProjection(principal, rate, years);
        System.out.printf("%nFinal value after %d years: ₹%.2f%n",
                years, futureValue(principal, rate, years));

        System.out.println("\n=== Fibonacci Growth Index (memoized) ===");
        for (int i = 1; i <= 10; i++)
            System.out.printf("  Month %2d → index %d%n", i, fib(i));

        System.out.println("\n--- Complexity ---");
        System.out.println("futureValue      : O(n) time, O(n) stack");
        System.out.println("Plain Fibonacci  : O(2^n) — avoid");
        System.out.println("Memoized Fibonacci: O(n) — each sub-problem once");
    }
}