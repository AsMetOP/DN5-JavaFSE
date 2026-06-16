import java.util.Arrays;

// ─────────────────────────────────────────────
// Exercise 3: Sorting Customer Orders
// Bubble Sort → O(n²)
// Quick Sort  → O(n log n) average
// ─────────────────────────────────────────────

public class Exercise3_SortingOrders {

    static class Order {
        int    orderId;
        String customerName;
        double totalPrice;

        Order(int orderId, String customerName, double totalPrice) {
            this.orderId      = orderId;
            this.customerName = customerName;
            this.totalPrice   = totalPrice;
        }

        @Override
        public String toString() {
            return String.format("Order[id=%d, customer=%s, total=%.2f]",
                    orderId, customerName, totalPrice);
        }
    }

    // Bubble Sort: O(n²) — with early-exit flag
    static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order tmp = orders[j]; orders[j] = orders[j+1]; orders[j+1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Quick Sort: O(n log n) average
    static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order tmp = orders[i]; orders[i] = orders[j]; orders[j] = tmp;
            }
        }
        Order tmp = orders[i+1]; orders[i+1] = orders[high]; orders[high] = tmp;
        return i + 1;
    }

    static void print(Order[] orders) {
        for (Order o : orders) System.out.println("  " + o);
    }

    public static void main(String[] args) {
        Order[] original = {
            new Order(1, "Arjun",  4500.00),
            new Order(2, "Sneha",  1200.50),
            new Order(3, "Rahul", 15000.00),
            new Order(4, "Priya",   800.00),
            new Order(5, "Kiran",  9999.99),
        };

        Order[] bubbleArr = Arrays.copyOf(original, original.length);
        bubbleSort(bubbleArr);
        System.out.println("=== Bubble Sort (by totalPrice) ===");
        print(bubbleArr);

        Order[] quickArr = Arrays.copyOf(original, original.length);
        quickSort(quickArr, 0, quickArr.length - 1);
        System.out.println("\n=== Quick Sort (by totalPrice) ===");
        print(quickArr);

        System.out.println("\n--- Complexity ---");
        System.out.println("Bubble Sort : O(n²)      — simple, slow on large data");
        System.out.println("Quick Sort  : O(n log n) — preferred for real workloads");
    }
}