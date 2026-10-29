import javax.swing.JFrame;

public class ReportFrame extends JFrame {

    public ReportFrame() {
        setTitle("Report Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new ReportFrame().setVisible(true);
        });
    }
}
