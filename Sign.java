import javax.swing.*;
import java.awt.*;

public class Sign {

    public static void main(String[] args) {

        JFrame frame = new JFrame("CampusConnect - Student");

        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JLabel title = new JLabel(
                "Student Details",
                SwingConstants.CENTER
        );

        JLabel nameLabel = new JLabel("Name:");
        JLabel rollLabel = new JLabel("Roll No:");
        JLabel departmentLabel = new JLabel("Department:");
        JLabel semesterLabel = new JLabel("Semester:");
        JLabel collegeLabel = new JLabel("College:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel phoneLabel = new JLabel("Phone:");

        JTextField nameField = new JTextField();
        JTextField rollField = new JTextField();
        JTextField departmentField = new JTextField();
        JTextField semesterField = new JTextField();
        JTextField collegeField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();

        JButton saveButton = new JButton("Save");

        frame.add(title);
        frame.add(new JLabel());

        frame.add(nameLabel);
        frame.add(nameField);

        frame.add(rollLabel);
        frame.add(rollField);

        frame.add(departmentLabel);
        frame.add(departmentField);

        frame.add(semesterLabel);
        frame.add(semesterField);

        frame.add(collegeLabel);
        frame.add(collegeField);

        frame.add(emailLabel);
        frame.add(emailField);

        frame.add(phoneLabel);
        frame.add(phoneField);

        frame.add(new JLabel());
        frame.add(saveButton);

        saveButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Student Details Saved!"
            );

        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}