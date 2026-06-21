public class TaskList {
    private Task head;

    public void add(Task t) {
        if (head == null) {
            head = t;
        } else {
            Task curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = t;
        }
        System.out.println("Added: " + t.taskName);
    }

    public void traverse() {
        Task curr = head;
        while (curr != null) {
            System.out.println(curr.taskId + " | " + curr.taskName + " | " + curr.status);
            curr = curr.next;
        }
    }

    public Task search(int id) {
        Task curr = head;
        while (curr != null) {
            if (curr.taskId == id) return curr;
            curr = curr.next;
        }
        return null;
    }

    public void delete(int id) {
        if (head == null) return;
        if (head.taskId == id) {
            System.out.println("Deleted: " + head.taskName);
            head = head.next;
            return;
        }
        Task curr = head;
        while (curr.next != null) {
            if (curr.next.taskId == id) {
                System.out.println("Deleted: " + curr.next.taskName);
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
        System.out.println("Task not found");
    }
}