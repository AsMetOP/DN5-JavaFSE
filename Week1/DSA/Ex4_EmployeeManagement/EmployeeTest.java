public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);
        manager.add(new Employee(1, "Asmet", "Developer", 60000));
        manager.add(new Employee(2, "Keshi", "Designer", 55000));
        manager.add(new Employee(3, "Aryan", "Manager", 80000));

        System.out.println("All Employees:");
        manager.traverse();

        Employee e = manager.search(3);
        System.out.println("Search: " + (e != null ? e.name : "Not found"));

        manager.delete(3);
        System.out.println("After Deletion:");
        manager.traverse();
    }
}