import javax.swing.JFrame;

public class VenueFrame extends JFrame {

    public VenueFrame() {
        setTitle("Venue Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new VenueFrame().setVisible(true);
        });
    }
}
