import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        // Window settings
        setTitle("Campus Event Manager");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main white panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // ---------------- HEADER ----------------

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);

        JLabel title = new JLabel("Campus Event Manager");
        title.setFont(new Font("Arial", Font.BOLD, 25));

        // Three dot button
        JButton menuButton = new JButton("⋮");
        menuButton.setFont(new Font("Arial", Font.BOLD, 25));
        menuButton.setBorderPainted(false);
        menuButton.setFocusPainted(false);
        menuButton.setBackground(Color.WHITE);

        // Three-dot menu
        JPopupMenu menu = new JPopupMenu();

        JMenuItem profile = new JMenuItem("Profile");
        JMenuItem settings = new JMenuItem("Settings");

        menu.add(profile);
        menu.add(settings);

        menuButton.addActionListener(e -> {
            menu.show(menuButton, 0, menuButton.getHeight());
        });

        header.add(title, BorderLayout.WEST);
        header.add(menuButton, BorderLayout.EAST);

        // ---------------- CENTER ----------------

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel welcome = new JLabel("Welcome to Campus Event Manager");
        welcome.setFont(new Font("Arial", Font.BOLD, 28));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel instruction = new JLabel("Please select your role");
        instruction.setFont(new Font("Arial", Font.PLAIN, 18));
        instruction.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Student button
        JButton studentButton = new JButton("Student");
        studentButton.setFont(new Font("Arial", Font.BOLD, 18));
        studentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        studentButton.setPreferredSize(new Dimension(220, 55));
        studentButton.setMaximumSize(new Dimension(220, 55));

        // Organizer button
        JButton organizerButton = new JButton("Organizer");
        organizerButton.setFont(new Font("Arial", Font.BOLD, 18));
        organizerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        organizerButton.setPreferredSize(new Dimension(220, 55));
        organizerButton.setMaximumSize(new Dimension(220, 55));

        // Space between components
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(welcome);
        centerPanel.add(Box.createVerticalStrut(15));
        centerPanel.add(instruction);
        centerPanel.add(Box.createVerticalStrut(30));
        centerPanel.add(studentButton);
        centerPanel.add(Box.createVerticalStrut(15));
        centerPanel.add(organizerButton);
        centerPanel.add(Box.createVerticalGlue());

        // Add everything
        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    public static void main(String[] args) {

        DashboardFrame frame = new DashboardFrame();
        frame.setVisible(true);
    }
}