import javax.swing.*;
import java.awt.*;

public class LoginFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("CampusConnect Login");

        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel title = new JLabel(
                "CampusConnect Login",
                SwingConstants.CENTER
        );

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        frame.add(title);
        frame.add(new JLabel());

        frame.add(usernameLabel);
        frame.add(usernameField);

        frame.add(passwordLabel);
        frame.add(passwordField);

        frame.add(new JLabel());
        frame.add(loginButton);

        loginButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Login Successful!"
            );

        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}