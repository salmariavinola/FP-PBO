public class MainAppLauncher {
    public static void main(String[] args) {
        LoginApp loginApp = new LoginApp();
        User user = loginApp.displayLogin();

        if (user != null) {
            System.out.println("Login successful!");
            if (user instanceof Admin) {
                Admin admin = (Admin) user; // Cast to Admin
                admin.manageTasks(); // Admin-specific functionality
                new ToDoListAppGUI(); // Launch GUI
            } else if (user instanceof Student) {
                Student student = (Student) user; // Cast to Student
                student.viewTasks(); // Student-specific functionality
            }
        } else {
            System.out.println("Login failed. Exiting application.");
        }
    }
}
