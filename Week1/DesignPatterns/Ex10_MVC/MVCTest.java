public class MVCTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Asmet Ranjan Sahoo");
        student.setId("24057021");
        student.setGrade("A");

        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentGrade("A+");
        controller.updateView();
    }
}