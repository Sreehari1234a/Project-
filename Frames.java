import javax.swing.*;
import java.awt.*;

public class Frames {

    // Frame 1 - Login
    static void loginFrame() {

        JFrame frame = new JFrame("CampusConnect - Login");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel title = new JLabel("CampusConnect Login", SwingConstants.CENTER);
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();

        JButton loginButton = new JButton("Login");

        frame.add(title);
        frame.add(new JLabel());

        frame.add(userLabel);
        frame.add(username);

        frame.add(passLabel);
        frame.add(password);

        frame.add(new JLabel());
        frame.add(loginButton);

        loginButton.addActionListener(e -> {
            frame.dispose();
            dashboardFrame();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Frame 2 - Student Dashboard
    static void dashboardFrame() {

        JFrame frame = new JFrame("Student Dashboard");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel heading = new JLabel(
                "Student Dashboard",
                SwingConstants.CENTER
        );

        JButton browseButton = new JButton("Browse Events");
        JButton registrationButton = new JButton("My Registrations");
        JButton logoutButton = new JButton("Logout");

        panel.add(heading);
        panel.add(browseButton);
        panel.add(registrationButton);
        panel.add(logoutButton);

        browseButton.addActionListener(e -> {
            frame.dispose();
            browseEventsFrame();
        });

        registrationButton.addActionListener(e -> {
            myRegistrationsFrame();
        });

        logoutButton.addActionListener(e -> {
            frame.dispose();
            loginFrame();
        });

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Frame 3 - Browse Events
    static void browseEventsFrame() {

        JFrame frame = new JFrame("Browse Events");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel heading = new JLabel(
                "Available Events",
                SwingConstants.CENTER
        );

        JButton event1 = new JButton("Tech Fest");
        JButton event2 = new JButton("Hackathon");
        JButton event3 = new JButton("Sports Meet");
        JButton back = new JButton("Back");

        panel.add(heading);
        panel.add(event1);
        panel.add(event2);
        panel.add(event3);
        panel.add(back);

        event1.addActionListener(e -> eventDetailsFrame("Tech Fest"));
        event2.addActionListener(e -> eventDetailsFrame("Hackathon"));
        event3.addActionListener(e -> eventDetailsFrame("Sports Meet"));

        back.addActionListener(e -> {
            frame.dispose();
            dashboardFrame();
        });

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Frame 4 - Event Details
    static void eventDetailsFrame(String eventName) {

        JFrame frame = new JFrame("Event Details");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel title = new JLabel(
                eventName,
                SwingConstants.CENTER
        );

        JLabel date = new JLabel(
                "Date: 20 October 2026",
                SwingConstants.CENTER
        );

        JLabel venue = new JLabel(
                "Venue: College Auditorium",
                SwingConstants.CENTER
        );

        JButton register = new JButton("Register");

        panel.add(title);
        panel.add(date);
        panel.add(venue);
        panel.add(register);

        register.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    frame,
                    "Registration Successful!"
            );
        });

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Frame 5 - My Registrations
    static void myRegistrationsFrame() {

        JFrame frame = new JFrame("My Registrations");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel heading = new JLabel(
                "My Registrations",
                SwingConstants.CENTER
        );

        JLabel event1 = new JLabel(
                "1. Tech Fest - Registered"
        );

        JLabel event2 = new JLabel(
                "2. Hackathon - Registered"
        );

        JButton close = new JButton("Close");

        panel.add(heading);
        panel.add(event1);
        panel.add(event2);
        panel.add(close);

        close.addActionListener(e -> frame.dispose());

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            loginFrame();
        });
    }
}