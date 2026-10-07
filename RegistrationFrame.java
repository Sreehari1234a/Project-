import javax.swing.JFrame;

public class RegistrationFrame extends JFrame {

    public RegistrationFrame() {
        setTitle("Registration Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new RegistrationFrame().setVisible(true);
        });
    }
}
