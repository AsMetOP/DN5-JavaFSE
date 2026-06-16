import java.util.Arrays;
import java.util.Comparator;

// ─────────────────────────────────────────────
// Exercise 2: E-commerce Search
// Linear Search  → O(n)
// Binary Search  → O(log n) — sorted array
// ─────────────────────────────────────────────

public class Exercise2_EcommerceSearch {

    static class Product {
        int    productId;
        String productName;
        String category;

        Product(int productId, String productName, String category) {
            this.productId   = productId;
            this.productName = productName;
            this.category    = category;
        }

        @Override
        public String toString() {
            return String.format("Product[id=%d, name=%s, category=%s]",
                    productId, productName, category);
        }
    }

    // O(n) — no sorting required
    static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products)
            if (p.productId == targetId) return p;
        return null;
    }

    // O(log n) — array must be sorted by productId
    static Product binarySearch(Product[] sorted, int targetId) {
        int low = 0, high = sorted.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if      (sorted[mid].productId == targetId) return sorted[mid];
            else if (sorted[mid].productId <  targetId) low  = mid + 1;
            else                                        high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(104, "Keyboard", "Peripherals"),
            new Product(201, "Webcam",   "Peripherals"),
            new Product(305, "SSD",      "Storage"),
            new Product(410, "RAM",      "Memory"),
            new Product(512, "CPU Fan",  "Cooling"),
        };

        System.out.println("=== Linear Search ===");
        Product r = linearSearch(products, 305);
        System.out.println(r != null ? "Found: " + r : "Not Found");
        r = linearSearch(products, 999);
        System.out.println(r != null ? "Found: " + r : "Not Found (999)");

        Product[] sorted = Arrays.copyOf(products, products.length);
        Arrays.sort(sorted, Comparator.comparingInt(p -> p.productId));

        System.out.println("\n=== Binary Search ===");
        r = binarySearch(sorted, 410);
        System.out.println(r != null ? "Found: " + r : "Not Found");
        r = binarySearch(sorted, 999);
        System.out.println(r != null ? "Found: " + r : "Not Found (999)");

        System.out.println("\n--- Complexity ---");
        System.out.println("Linear : O(n)     — no sorting needed");
        System.out.println("Binary : O(log n) — requires sorted data");
    }
}