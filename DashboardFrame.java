import javax.swing.JFrame;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {
        setTitle("Dashboard Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
       
            new DashboardFrame().setVisible(true);
        });
    }
}
