public class InventoryTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product(1, "Laptop", 10, 75000));
        inventory.addProduct(new Product(2, "Mouse", 50, 500));
        inventory.updateProduct(1, 8, 70000);
        inventory.deleteProduct(2);
        inventory.deleteProduct(99);
    }
}