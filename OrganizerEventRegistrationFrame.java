import javax.swing.*;
import java.awt.*;

public class OrganizerEventRegistrationFrame extends JFrame {

    public OrganizerEventRegistrationFrame() {

        setTitle("Organizer - Register Event");
        setSize(650, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title
        JLabel title = new JLabel("Register New Event");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(25));
        panel.add(title);
        panel.add(Box.createVerticalStrut(25));

        // Event Name
        JLabel eventNameLabel = new JLabel("Event Name");
        JTextField eventNameField = new JTextField();
        eventNameField.setMaximumSize(new Dimension(450, 40));

        panel.add(eventNameLabel);
        panel.add(eventNameField);
        panel.add(Box.createVerticalStrut(12));

        // Organizer Name
        JLabel organizerLabel = new JLabel("Organizer Name");
        JTextField organizerField = new JTextField();
        organizerField.setMaximumSize(new Dimension(450, 40));

        panel.add(organizerLabel);
        panel.add(organizerField);
        panel.add(Box.createVerticalStrut(12));

        // Tutor / Faculty Name
        JLabel tutorLabel = new JLabel("Tutor / Faculty Name");
        JTextField tutorField = new JTextField();
        tutorField.setMaximumSize(new Dimension(450, 40));

        panel.add(tutorLabel);
        panel.add(tutorField);
        panel.add(Box.createVerticalStrut(12));

        // Number of Seats
        JLabel seatsLabel = new JLabel("No. of Seats");
        JTextField seatsField = new JTextField();
        seatsField.setMaximumSize(new Dimension(450, 40));

        panel.add(seatsLabel);
        panel.add(seatsField);
        panel.add(Box.createVerticalStrut(12));

        // Event Date
        JLabel dateLabel = new JLabel("Event Date");
        JTextField dateField = new JTextField();
        dateField.setMaximumSize(new Dimension(450, 40));

        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(Box.createVerticalStrut(12));

        // Venue
        JLabel venueLabel = new JLabel("Venue");
        JTextField venueField = new JTextField();
        venueField.setMaximumSize(new Dimension(450, 40));

        panel.add(venueLabel);
        panel.add(venueField);
        panel.add(Box.createVerticalStrut(12));

        // Event Description
        JLabel descriptionLabel = new JLabel("Event Description");

        JTextArea descriptionArea = new JTextArea(4, 30);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        JScrollPane descriptionScroll =
                new JScrollPane(descriptionArea);

        descriptionScroll.setMaximumSize(
                new Dimension(450, 100)
        );

        panel.add(descriptionLabel);
        panel.add(descriptionScroll);
        panel.add(Box.createVerticalStrut(20));

        // Register Button
        JButton registerButton = new JButton("Register Event");
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(registerButton);

        add(panel);
    }

    public static void main(String[] args) {

        OrganizerEventRegistrationFrame frame =
                new OrganizerEventRegistrationFrame();

        frame.setVisible(true);
    }
}
