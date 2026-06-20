import java.util.HashMap;

public class Inventory {
    private HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product p) {
        products.put(p.productId, p);
        System.out.println("Added: " + p.productName);
    }

    public void updateProduct(int id, int quantity, double price) {
        Product p = products.get(id);
        if (p != null) {
            p.quantity = quantity;
            p.price = price;
            System.out.println("Updated: " + p.productName);
        } else {
            System.out.println("Product not found");
        }
    }

    public void deleteProduct(int id) {
        Product p = products.remove(id);
        if (p != null) {
            System.out.println("Deleted: " + p.productName);
        } else {
            System.out.println("Product not found");
        }
    }
}