public class SearchTest {
    public static void main(String[] args) {
        // Here, Array is sorted alphabetically for binary search
        Product[] products = {
            new Product(1, "Camera", "Electronics"),
            new Product(2, "Laptop", "Electronics"),
            new Product(3, "Phone", "Electronics")
        };

        int i1 = SearchUtil.linearSearch(products, "Laptop");
        System.out.println("Linear Search - Laptop: index " + i1);

        int i2 = SearchUtil.binarySearch(products, "Camera");
        System.out.println("Binary Search - Camera: index " + i2);

        int i3 = SearchUtil.binarySearch(products, "Tablet");
        System.out.println("Binary Search - Tablet: index " + i3);
    }
}