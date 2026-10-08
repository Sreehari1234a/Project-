import javax.swing.*;
import java.awt.*;

public class ParticipantProfileFrame extends JFrame {

    public ParticipantProfileFrame() {

        setTitle("My Profile");
        setSize(650, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Main Title
        JLabel title = new JLabel("Campus Event Manager");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Profile Title
        JLabel profileTitle = new JLabel("My Profile");
        profileTitle.setFont(new Font("Arial", Font.BOLD, 28));
        profileTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(Box.createVerticalStrut(25));
        mainPanel.add(title);
        mainPanel.add(Box.createVerticalStrut(25));
        mainPanel.add(profileTitle);
        mainPanel.add(Box.createVerticalStrut(30));

        // Name
        JLabel nameLabel = new JLabel("Name");
        JTextField nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(450, 40));

        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(Box.createVerticalStrut(12));

        // Email
        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField();
        emailField.setMaximumSize(new Dimension(450, 40));

        mainPanel.add(emailLabel);
        mainPanel.add(emailField);
        mainPanel.add(Box.createVerticalStrut(12));

        // Phone Number
        JLabel phoneLabel = new JLabel("Phone Number");
        JTextField phoneField = new JTextField();
        phoneField.setMaximumSize(new Dimension(450, 40));

        mainPanel.add(phoneLabel);
        mainPanel.add(phoneField);
        main

