public class DependencyInjectionTest {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        service.printCustomer(101);
        service.printCustomer(102);
        service.printCustomer(999);
    }
}