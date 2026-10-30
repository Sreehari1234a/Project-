

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends BaseFrame {

    private final String role;

    public DashboardFrame(String role) {
        super("CampusConnect - " + role + " Dashboard");
        this.role = role;

        Account account = AppData.currentAccount;

        String name = account == null
                ? ""
                : account.getName();

        JPanel page = createPage(
            role + " Dashboard",
            "Welcome, " + name
        );

        JPanel buttons = new JPanel(new GridLayout(0, 1, 12, 12));
        buttons.setOpaque(false);

        JButton profile = createButton("My Profile");

        profile.addActionListener(e -> {
            new ProfileFrame().setVisible(true);
            dispose();
        });

        buttons.add(profile);

        if (role.equals("Student")) {
            JButton events = createButton("Browse Events");
            JButton registrations =
                createButton("My Registrations");

            events.addActionListener(e -> {
                new EventsFrame(false).setVisible(true);
                dispose();
            });

            registrations.addActionListener(e -> {
                new RegistrationsFrame().setVisible(true);
                dispose();
            });

            buttons.add(events);
            buttons.add(registrations);

        } else {
            JButton create = createButton("Create Event");
            JButton events = createButton("View Events");

            create.addActionListener(e -> {
                new CreateEventFrame().setVisible(true);
                dispose();
            });

            events.addActionListener(e -> {
                new EventsFrame(true).setVisible(true);
                dispose();
            });

            buttons.add(create);
            buttons.add(events);
        }

        JButton logout = createButton("Logout");

        logout.addActionListener(e -> {
            AppData.currentAccount = null;
            new RoleSelectionFrame().setVisible(true);
            dispose();
        });

        buttons.add(logout);

        page.add(buttons, BorderLayout.CENTER);
        setContentPane(page);
    }
}
import javax.swing.JFrame;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {
        setTitle("Dashboard Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     
    }

    public static void main(String[] args) {
       
            new DashboardFrame().setVisible(true);
        };
    }
