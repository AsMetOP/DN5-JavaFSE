import java.util.HashMap;
import java.util.Map;

// ─────────────────────────────────────────────
// Exercise 1: Inventory Management System
// Data Structure: HashMap<productId, Product>
// add/update/delete → O(1) average
// ─────────────────────────────────────────────

public class Exercise1_InventoryManagement {

    static class Product {
        int productId;
        String productName;
        int quantity;
        double price;

        Product(int productId, String productName, int quantity, double price) {
            this.productId   = productId;
            this.productName = productName;
            this.quantity    = quantity;
            this.price       = price;
        }

        @Override
        public String toString() {
            return String.format("Product[id=%d, name=%s, qty=%d, price=%.2f]",
                    productId, productName, quantity, price);
        }
    }

    static class Inventory {
        private Map<Integer, Product> store = new HashMap<>();

        void addProduct(Product p) {
            if (store.containsKey(p.productId)) {
                System.out.println("ID " + p.productId + " already exists. Use updateProduct().");
                return;
            }
            store.put(p.productId, p);
            System.out.println("Added: " + p);
        }

        void updateProduct(int id, int newQty, double newPrice) {
            Product p = store.get(id);
            if (p == null) { System.out.println("ID " + id + " not found."); return; }
            p.quantity = newQty;
            p.price    = newPrice;
            System.out.println("Updated: " + p);
        }

        void deleteProduct(int id) {
            Product removed = store.remove(id);
            if (removed == null) System.out.println("ID " + id + " not found.");
            else System.out.println("Deleted: " + removed);
        }

        void displayAll() {
            if (store.isEmpty()) { System.out.println("Inventory is empty."); return; }
            store.values().forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        Inventory inv = new Inventory();

        inv.addProduct(new Product(101, "Laptop",  50, 75000.00));
        inv.addProduct(new Product(102, "Mouse",  200,   499.00));
        inv.addProduct(new Product(103, "Monitor", 30, 15000.00));

        System.out.println("\n--- All Products ---");
        inv.displayAll();

        System.out.println("\n--- Update Mouse ---");
        inv.updateProduct(102, 180, 449.00);

        System.out.println("\n--- Delete Monitor ---");
        inv.deleteProduct(103);

        System.out.println("\n--- Final Inventory ---");
        inv.displayAll();

        System.out.println("\n--- Complexity ---");
        System.out.println("add / update / delete : O(1) average (HashMap)");
    }
}