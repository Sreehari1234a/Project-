
import javax.swing.*;
import java.awt.*;

public class ProfileFrame extends BaseFrame {

    public ProfileFrame() {
        super("CampusConnect - My Profile");

        Account account = AppData.currentAccount;

        JPanel page = createPage(
            "My Profile",
            "View your registered account details"
        );

        JPanel details = new JPanel(new GridLayout(0, 2, 12, 14));
        details.setBackground(WHITE);
        details.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 235)),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
            )
        );

        addDetail(details, "Full Name", account.getName());
        addDetail(details, "Email", account.getEmail());
        addDetail(details, "Phone Number", account.getPhone());
        addDetail(details, "Username", account.getUsername());
        addDetail(details, "Role", account.getRole());

        if (account.getRole().equals("Student")) {
            addDetail(details, "Department", account.getDepartment());
            addDetail(details, "Semester", account.getSemester());
        } else {
            addDetail(
                details,
                "Organization Name",
                account.getOrganization()
            );
        }

        page.add(details, BorderLayout.CENTER);

        JButton back = createButton("Back to Dashboard");

        back.addActionListener(e -> {
            new DashboardFrame(account.getRole()).setVisible(true);
            dispose();
        });

        page.add(back, BorderLayout.SOUTH);

        setContentPane(page);
    }

    private void addDetail(JPanel panel, String label, String value) {
        JLabel labelText = new JLabel(label);
        labelText.setFont(new Font("Arial", Font.BOLD, 14));
        labelText.setForeground(DARK);

        JLabel valueText = new JLabel(
            value == null || value.isEmpty() ? "Not provided" : value
        );
        valueText.setFont(new Font("Arial", Font.PLAIN, 14));

        panel.add(labelText);
        panel.add(valueText);
    }
}
