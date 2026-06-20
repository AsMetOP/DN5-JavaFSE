public class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int id) {
        if (id == 101) {
            return "Asmet Ranjan Sahoo";
        } else if (id == 102) {
            return "Keshi Jain";
        }
        return "Customer not found";
    }
}