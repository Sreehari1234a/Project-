import javax.swing.JFrame;

public class EventFrame extends JFrame {

    public EventFrame() {
        setTitle("Event Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
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
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new EventFrame().setVisible(true);
        });
    }
}
