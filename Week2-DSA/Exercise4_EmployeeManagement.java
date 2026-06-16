// ─────────────────────────────────────────────
// Exercise 4: Employee Management System
// Data Structure: Fixed-size Array
// add → O(1)  |  search/delete → O(n)
// ─────────────────────────────────────────────

public class Exercise4_EmployeeManagement {

    static class Employee {
        int    employeeId;
        String name;
        String position;
        double salary;

        Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name       = name;
            this.position   = position;
            this.salary     = salary;
        }

        @Override
        public String toString() {
            return String.format("Employee[id=%d, name=%s, position=%s, salary=%.2f]",
                    employeeId, name, position, salary);
        }
    }

    static class EmployeeManager {
        private Employee[] employees;
        private int size;
        private final int CAPACITY;

        EmployeeManager(int capacity) {
            CAPACITY  = capacity;
            employees = new Employee[capacity];
            size      = 0;
        }

        void addEmployee(Employee e) {
            if (size == CAPACITY) { System.out.println("Array full!"); return; }
            employees[size++] = e;
            System.out.println("Added: " + e);
        }

        Employee searchById(int id) {
            for (int i = 0; i < size; i++)
                if (employees[i].employeeId == id) return employees[i];
            return null;
        }

        void traverse() {
            if (size == 0) { System.out.println("No employees."); return; }
            System.out.println("--- Employee Records (" + size + ") ---");
            for (int i = 0; i < size; i++) System.out.println("  " + employees[i]);
        }

        boolean deleteEmployee(int id) {
            for (int i = 0; i < size; i++) {
                if (employees[i].employeeId == id) {
                    System.out.println("Deleted: " + employees[i]);
                    for (int j = i; j < size - 1; j++) employees[j] = employees[j + 1];
                    employees[--size] = null;
                    return true;
                }
            }
            System.out.println("ID " + id + " not found.");
            return false;
        }
    }

    public static void main(String[] args) {
        EmployeeManager mgr = new EmployeeManager(10);

        mgr.addEmployee(new Employee(1, "Asmet",  "SDE Intern",   25000));
        mgr.addEmployee(new Employee(2, "Pooja",  "Data Analyst",  55000));
        mgr.addEmployee(new Employee(3, "Vikram", "DevOps Lead",   90000));
        mgr.addEmployee(new Employee(4, "Anita",  "QA Engineer",   60000));

        System.out.println();
        mgr.traverse();

        System.out.println("\n--- Search ID 3 ---");
        Employee e = mgr.searchById(3);
        System.out.println(e != null ? "Found: " + e : "Not Found");

        System.out.println("\n--- Delete ID 2 ---");
        mgr.deleteEmployee(2);
        mgr.traverse();

        System.out.println("\n--- Complexity ---");
        System.out.println("add (end) : O(1)");
        System.out.println("search    : O(n)");
        System.out.println("delete    : O(n) — left shift");
    }
}