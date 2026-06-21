public class TaskTest {
    public static void main(String[] args) {
        TaskList list = new TaskList();
        list.add(new Task(1, "Design UI", "Pending"));
        list.add(new Task(2, "Write Tests", "In Progress"));
        list.add(new Task(3, "Deploy App", "Pending"));

        System.out.println("All Tasks:");
        list.traverse();

        Task t = list.search(2);
        System.out.println("Search: " + (t != null ? t.taskName : "Not found"));

        list.delete(2);
        System.out.println("After Deletion:");
        list.traverse();
    }
}