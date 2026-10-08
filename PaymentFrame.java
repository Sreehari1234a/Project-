import javax.swing.JFrame;

public class PaymentFrame extends JFrame {

    public PaymentFrame() {
        setTitle("Payment Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new PaymentFrame().setVisible(true);
        });
    }
}
