public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password); // Call the User constructor
    }

    public void manageTasks() {
        System.out.println("Admin " + username + " can manage tasks.");
    }
}
