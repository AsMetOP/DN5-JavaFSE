public class ProxyTest {
    public static void main(String[] args) {
        Image img = new ProxyImage("vacation.jpg");

        img.display();
        System.out.println("---");
        img.display();
    }
}