import javax.swing.JFrame;

public class ParticipantFrame extends JFrame {

    public ParticipantFrame() {
        setTitle("Participant Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new ParticipantFrame().setVisible(true);
        });
    }
}
