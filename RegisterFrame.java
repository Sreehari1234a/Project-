import javax.swing.JFrame;

public class RegisterFrame extends JFrame {

    public RegisterFrame() {
        setTitle("Register Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
            new RegisterFrame().setVisible(true);
        });
    }
}
