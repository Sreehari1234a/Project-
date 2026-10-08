import javax.swing.JFrame;

public class EventDetailsFrame extends JFrame {

    public EventDetailsFrame() {
        setTitle("EventDetails Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
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
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new EventDetailsFrame().setVisible(true);
        });
    }
}
