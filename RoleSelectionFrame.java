
import javax.swing.*;
import java.awt.*;

public class RoleSelectionFrame extends BaseFrame {

    public RoleSelectionFrame() {
        super("CampusConnect - Welcome");

        JPanel page = createPage(
            "CampusConnect",
            "Welcome! Please choose your role."
        );

        JPanel choices = new JPanel(new GridLayout(2, 1, 15, 15));
        choices.setOpaque(false);

        JButton student = createButton("Student");
        JButton organizer = createButton("Organizer");

        student.addActionListener(e -> {
            new AuthFrame("Student").setVisible(true);
            dispose();
        });

        organizer.addActionListener(e -> {
            new AuthFrame("Organizer").setVisible(true);
            dispose();
        });

        choices.add(student);
        choices.add(organizer);

        page.add(choices, BorderLayout.CENTER);
        setContentPane(page);
    }
}
