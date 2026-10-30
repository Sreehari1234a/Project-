
import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame {
    protected final Color BG = new Color(245, 247, 252);
    protected final Color BLUE = new Color(45, 95, 180);
    protected final Color DARK = new Color(30, 41, 59);
    protected final Color WHITE = Color.WHITE;

    public BaseFrame(String title) {
        super(title);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected JPanel createPage(String title, String subtitle) {
        JPanel page = new JPanel(new BorderLayout(15, 15));
        page.setBackground(BG);
        page.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        JPanel heading = new JPanel(new GridLayout(2, 1, 5, 5));
        heading.setOpaque(false);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setForeground(DARK);

        JLabel subLabel = new JLabel(subtitle);
        subLabel.setForeground(Color.GRAY);

        heading.add(titleLabel);
        heading.add(subLabel);
        page.add(heading, BorderLayout.NORTH);

        return page;
    }

    protected JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(BLUE);
        button.setForeground(WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    protected void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    protected void showError(String message) {
        JOptionPane.showMessageDialog(
            this, message, "Error", JOptionPane.ERROR_MESSAGE
        );
    }
}
