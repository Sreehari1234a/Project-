import javax.swing.*;
import java.awt.*;

public class PFiveFrames {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            String[] titles = {
                "Login Screen",
                "Student Dashboard",
                "Browse Events",
                "Event Details",
                "My Registrations"
            };

            for (int i = 0; i < titles.length; i++) {

                JFrame frame = new JFrame(titles[i]);

                frame.setSize(600, 400);
                frame.setDefaultCloseOperation(
                    JFrame.DISPOSE_ON_CLOSE
                );

                frame.getContentPane().setBackground(Color.WHITE);

                JLabel heading = new JLabel(
                    titles[i],
                    SwingConstants.CENTER
                );

                heading.setFont(
                    new Font("Arial", Font.PLAIN, 24)
                );

                frame.add(heading, BorderLayout.CENTER);

                frame.setLocation(50 + i * 30, 50 + i * 30);
                frame.setVisible(true);
            }
        });
    }
}
