public class Student extends User {
    public Student(String username, String password) {
        super(username, password); // Call the User constructor
    }

    public void viewTasks() {
        System.out.println("Student " + username + " can view tasks.");
    }
}
