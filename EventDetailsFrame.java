import javax.swing.JFrame;

public class EventDetailsFrame extends JFrame {

    public EventDetailsFrame() {
        setTitle("EventDetails Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new EventDetailsFrame().setVisible(true);
        });
    }
}
