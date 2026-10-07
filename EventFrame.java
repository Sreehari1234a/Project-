import javax.swing.JFrame;

public class EventFrame extends JFrame {

    public EventFrame() {
        setTitle("Event Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new EventFrame().setVisible(true);
        });
    }
}
