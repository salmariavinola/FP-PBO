import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToDoListAppGUI {
    private ArrayList<String> tasks = new ArrayList<>();
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public ToDoListAppGUI() {
        // Create the main frame
        JFrame frame = new JFrame("To-Do List Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        // Task list (JList with DefaultListModel)
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4, 5, 5));

        // Buttons
        JButton addButton = new JButton("Add Task");
        JButton completeButton = new JButton("Mark Completed");
        JButton deleteButton = new JButton("Delete Task");
        JButton exitButton = new JButton("Exit");

        // Add buttons to the panel
        buttonPanel.add(addButton);
        buttonPanel.add(completeButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(exitButton);

        // Add components to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Add task button action
        addButton.addActionListener(e -> {
            String task = JOptionPane.showInputDialog(frame, "Enter a task:");
            if (task != null && !task.trim().isEmpty()) {
                tasks.add(task);
                taskListModel.addElement(task);
            }
        });

        // Mark as completed button action
        completeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                String task = tasks.get(selectedIndex);
                tasks.set(selectedIndex, task + " (Completed)");
                taskListModel.set(selectedIndex, task + " (Completed)");
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a task to mark as completed.");
            }
        });

        // Delete button action
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                tasks.remove(selectedIndex);
                taskListModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a task to delete.");
            }
        });

        // Exit button action
        exitButton.addActionListener(e -> {
            frame.dispose();
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoListAppGUI::new);
    }
}
