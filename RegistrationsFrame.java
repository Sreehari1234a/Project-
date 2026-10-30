
import javax.swing.*;
import java.awt.*;

public class RegistrationsFrame extends BaseFrame {

    public RegistrationsFrame() {
        super("CampusConnect - My Registrations");

        JPanel page = createPage(
            "My Registrations", "Your registered events"
        );

        DefaultListModel<String> model = new DefaultListModel<>();
        String username = AppData.currentAccount.getUsername();

        for (Registration r : AppData.REGISTRATIONS) {
            if (r.getUsername().equalsIgnoreCase(username)) {
                model.addElement(r.getEventName());
            }
        }

        if (model.isEmpty()) {
            model.addElement("No registrations found.");
        }

        JList<String> list = new JList<>(model);
        list.setFont(new Font("Arial", Font.PLAIN, 16));
        page.add(new JScrollPane(list), BorderLayout.CENTER);

        JButton back = createButton("Back to Dashboard");
        back.addActionListener(e -> {
            new DashboardFrame("Student").setVisible(true);
            dispose();
        });

        page.add(back, BorderLayout.SOUTH);
        setContentPane(page);
    }
}
