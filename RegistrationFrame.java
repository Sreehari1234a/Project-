import javax.swing.JFrame;

public class RegistrationFrame extends JFrame {

    public RegistrationFrame() {
        setTitle("Registration Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
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

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new RegistrationFrame().setVisible(true);
        });
    }
}
