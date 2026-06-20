public class EmployeeManager {
    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void add(Employee e) {
        if (size < employees.length) {
            employees[size++] = e;
            System.out.println("Added: " + e.name);
        } else {
            System.out.println("Array full");
        }
    }

    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].employeeId + " | " + employees[i].name + " | " + employees[i].position + " | " + employees[i].salary);
        }
    }

    public Employee search(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) return employees[i];
        }
        return null;
    }

    public void delete(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Deleted: " + employees[i].name);
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return;
            }
        }
        System.out.println("Employee not found");
    }
}