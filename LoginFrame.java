import javax.swing.JFrame;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Login Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
    }

    public static void main(String[]args){
            new LoginFrame().setVisible(true);
        });
    }
}
