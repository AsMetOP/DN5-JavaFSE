public class CustomerService {
    private CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public void printCustomer(int id) {
        String name = repo.findCustomerById(id);
        System.out.println("Customer: " + name);
    }
}