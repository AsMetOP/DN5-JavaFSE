public class SortTest {
    public static void main(String[] args) {
        Order[] orders1 = {
            new Order(1, "Asmet", 5000),
            new Order(2, "Keshi", 1500),
            new Order(3, "Aryan", 3200)
        };

        SortUtil.bubbleSort(orders1);
        System.out.println("Bubble Sort:");
        for (Order o : orders1) {
            System.out.println(o.customerName + " - " + o.totalPrice);
        }

        Order[] orders2 = {
            new Order(1, "Asmet", 5000),
            new Order(2, "Keshi", 1500),
            new Order(3, "Aryan", 3200)
        };

        SortUtil.quickSort(orders2, 0, orders2.length - 1);
        System.out.println("Quick Sort:");
        for (Order o : orders2) {
            System.out.println(o.customerName + " - " + o.totalPrice);
        }
    }
}