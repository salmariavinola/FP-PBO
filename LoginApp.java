import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginApp {
    private User loggedInUser;

    public User displayLogin() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new GridLayout(3, 2, 5, 5));

        // Components for the login form
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);

        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            // Hardcoded logic to assign roles
            if (username.equals("salma") && password.equals("12345")) {
                loggedInUser = new Admin("salma", "12345"); // Admin user
                frame.dispose();
            } else if (username.equals("casey") && password.equals("12345")) {
                loggedInUser = new Student("casey", "12345"); // Student user
                frame.dispose();
            } else {
                messageLabel.setText("Invalid credentials!");
                messageLabel.setForeground(Color.RED);
            }
        });

        // Add components to the frame
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);
        frame.add(messageLabel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Wait for login process
        while (frame.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        return loggedInUser;
    }
}
