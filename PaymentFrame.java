import javax.swing.JFrame;

public class PaymentFrame extends JFrame {

    public PaymentFrame() {
        setTitle("Profile Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
    }

    public static void main(String[] args) {
       
            new PaymentFrame().setVisible(true);
      
    }
}
