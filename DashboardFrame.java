import javax.swing.JFrame;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {
        setTitle("Dashboard Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel heading = new JLabel(
                "Student Dashboard",
                SwingConstants.CENTER
        );

        JButton browseButton = new JButton("Browse Events");
        JButton registrationButton = new JButton("My Registrations");
        JButton logoutButton = new JButton("Logout");

        panel.add(heading);
        panel.add(browseButton);
        panel.add(registrationButton);
        panel.add(logoutButton);
    
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new DashboardFrame().setVisible(true);
        });
    }
}
