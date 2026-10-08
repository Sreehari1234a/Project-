import javax.swing.*;
import java.awt.*;

public class Organizer {

    public static void main(String[] args) {

        JFrame frame = new JFrame("CampusConnect - Organizer");

        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel title = new JLabel(
                "Organizer Dashboard",
                SwingConstants.CENTER
        );

        JButton createEvent = new JButton("Create Event");
        JButton viewEvents = new JButton("View Events");
        JButton viewRegistrations =
                new JButton("View Registrations");
        JButton logout = new JButton("Logout");

        panel.add(title);
        panel.add(createEvent);
        panel.add(viewEvents);
        panel.add(viewRegistrations);
        panel.add(logout);

        createEvent.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Create Event Frame"
            );

        });

        viewEvents.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "View Events Frame"
            );

        });

        viewRegistrations.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "View Registrations Frame"
            );

        });

        logout.addActionListener(e -> {

            frame.dispose();

        });

        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}