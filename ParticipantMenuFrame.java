import javax.swing.*;
import java.awt.*;

public class ParticipantMenuFrame extends JFrame {

    public ParticipantMenuFrame() {

        setTitle("Participant Menu");
        setSize(750, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // ---------------- HEADER ----------------

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);

        JLabel title = new JLabel("Campus Event Manager");
        title.setFont(new Font("Arial", Font.BOLD, 25));

        JButton menuButton = new JButton("⋮");
        menuButton.setFont(new Font("Arial", Font.BOLD, 25));
        menuButton.setBorderPainted(false);
        menuButton.setFocusPainted(false);
        menuButton.setBackground(Color.WHITE);

        // Three-dot menu
        JPopupMenu menu = new JPopupMenu();

        JMenuItem dashboardItem =
                new JMenuItem("Back to Dashboard");

        JMenuItem logoutItem =
                new JMenuItem("Logout");

        menu.add(dashboardItem);
        menu.add(logoutItem);

        menuButton.addActionListener(e -> {
            menu.show(menuButton, 0, menuButton.getHeight());
        });

        // Back to Dashboard
        dashboardItem.addActionListener(e -> {
            DashboardFrame dashboard =
                    new DashboardFrame();

            dashboard.setVisible(true);
            dispose();
        });

        // Logout
        logoutItem.addActionListener(e -> {
            DashboardFrame dashboard =
                    new DashboardFrame();

            dashboard.setVisible(true);
            dispose();
        });

        header.add(title, BorderLayout.WEST);
        header.add(menuButton, BorderLayout.EAST);

        // ---------------- CENTER ----------------

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(
                new BoxLayout(centerPanel, BoxLayout.Y_AXIS)
        );

        JLabel welcome =
                new JLabel("Welcome, Participant");

        welcome.setFont(
                new Font("Arial", Font.BOLD, 24)
        );

        welcome.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centerPanel.add(
                Box.createVerticalStrut(25)
        );

        centerPanel.add(welcome);

        centerPanel.add(
                Box.createVerticalStrut(30)
        );

        // ---------------- BUTTONS ----------------

        JButton browseEventsButton =
                new JButton("Browse Events");

        JButton eventDetailsButton =
                new JButton("Event Details");

        JButton registerEventButton =
                new JButton("Register for Event");

        JButton myRegistrationsButton =
                new JButton("My Registrations");

        JButton certificatesButton =
                new JButton("My Certificates");

        JButton messagesButton =
                new JButton("Messages");

        JButton[] buttons = {
                browseEventsButton,
                eventDetailsButton,
                registerEventButton,
                myRegistrationsButton,
                certificatesButton,
                messagesButton
        };

        for (JButton button : buttons) {
            button.setFont(
                    new Font("Arial", Font.BOLD, 16)
            );
        }

        // 3 Rows × 2 Columns

        JPanel buttonPanel =
                new JPanel(
                        new GridLayout(3, 2, 20, 20)
                );

        buttonPanel.setBackground(Color.WHITE);

        buttonPanel.add(browseEventsButton);
        buttonPanel.add(eventDetailsButton);

        buttonPanel.add(registerEventButton);
        buttonPanel.add(myRegistrationsButton);

        buttonPanel.add(certificatesButton);
        buttonPanel.add(messagesButton);

        centerPanel.add(buttonPanel);

        mainPanel.add(
                header,
                BorderLayout.NORTH
        );

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        add(mainPanel);
    }

    public static void main(String[] args) {

        ParticipantMenuFrame frame =
                new ParticipantMenuFrame();

        frame.setVisible(true);
    }
                        }
