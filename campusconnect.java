
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class campusconnect extends JFrame {

    private final Color BG = new Color(241, 245, 252);
    private final Color BLUE = new Color(48, 83, 210);
    private final Color DARK = new Color(28, 40, 75);
    private final Color GREEN = new Color(15, 145, 115);
    private final Color WHITE = Color.WHITE;
    private final Color LIGHT_BLUE = new Color(232, 237, 255);

    private JPanel main;

    private String role = "Student";
    private String username = "Student";

    private String registeredName = "";
    private String registeredRoll = "";
    private String registeredDepartment = "";
    private String registeredSemester = "";
    private String registeredCollege = "";
    private String registeredEmail = "";
    private String registeredPhone = "";
    private String registeredUsername = "";
    private String registeredPassword = "";

    private String eventName = "Tech Fest 2026";
    private String eventDescription =
            "Technology exhibitions and coding activities";
    private String eventDate = "10 November 2026";
    private String eventVenue = "College Auditorium";

    private final ArrayList<String> participants =
            new ArrayList<>();

    private final ArrayList<String> eventList =
            new ArrayList<>();

    private JTextField loginUsername;
    private JPasswordField loginPassword;

    public campusconnect() {
        setTitle("CampusConnect - College Event Portal");
        setSize(950, 700);
        setMinimumSize(new Dimension(750, 550));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        main = new JPanel(new BorderLayout());
        main.setBackground(BG);

        setContentPane(main);

        eventList.add(eventName);

        showRoleSelection();
        setVisible(true);
    }

    // ---------- COMMON DESIGN ----------

    private void showPage(JPanel page) {
        main.removeAll();
        main.add(page, BorderLayout.CENTER);
        main.revalidate();
        main.repaint();
    }

    private JPanel createOuterPage() {
        JPanel outer = new JPanel(new BorderLayout());
        outer.setBackground(BG);
        return outer;
    }

    private void addHeader(JPanel outer, String section) {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(DARK);
        header.setBorder(new EmptyBorder(18, 30, 18, 30));

        JLabel logo = new JLabel("CAMPUSCONNECT");
        logo.setForeground(WHITE);
        logo.setFont(new Font("SansSerif", Font.BOLD, 22));

        JLabel label = new JLabel(section);
        label.setForeground(new Color(210, 220, 255));
        label.setFont(new Font("SansSerif", Font.PLAIN, 13));

        header.add(logo, BorderLayout.WEST);
        header.add(label, BorderLayout.EAST);

        outer.add(header, BorderLayout.NORTH);
    }

    private JPanel createCard(String heading, String subtitle) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(WHITE);
        card.setBorder(new EmptyBorder(30, 35, 30, 35));

        JLabel title = new JLabel(heading);
        title.setFont(new Font("SansSerif", Font.BOLD, 27));
        title.setForeground(DARK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel description = new JLabel(subtitle);
        description.setFont(new Font("SansSerif", Font.PLAIN, 14));
        description.setForeground(Color.GRAY);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(title);
        card.add(Box.createVerticalStrut(10));
        card.add(description);
        card.add(Box.createVerticalStrut(25));

        return card;
    }

    private void displayCard(JPanel outer, JPanel card) {
        JPanel center = new JPanel(new GridBagLayout());
        center.setBackground(BG);
        center.setBorder(new EmptyBorder(20, 20, 20, 20));
        center.add(card);

        JScrollPane scroll = new JScrollPane(center);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.getViewport().setBackground(BG);

        outer.add(scroll, BorderLayout.CENTER);
        showPage(outer);
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(color);
        button.setForeground(color.equals(LIGHT_BLUE) ? BLUE : WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(400, 44));
        button.setPreferredSize(new Dimension(400, 44));
        return button;
    }

    private void addButton(JPanel panel, String text,
                           Color color, Runnable action) {
        JButton button = createButton(text, color);
        button.addActionListener(e -> action.run());

        panel.add(button);
        panel.add(Box.createVerticalStrut(12));
    }

    private JTextField createField(String hint) {
        JTextField field = new JTextField();
        field.setFont(new Font("SansSerif", Font.PLAIN, 14));
        field.setMaximumSize(new Dimension(420, 38));
        field.setPreferredSize(new Dimension(420, 38));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        new Color(215, 222, 237)),
                new EmptyBorder(8, 12, 8, 12)));
        field.setToolTipText(hint);
        return field;
    }

    private void addField(JPanel panel, String name,
                          JTextField field) {
        JLabel label = new JLabel(name);
        label.setFont(new Font("SansSerif", Font.BOLD, 13));
        label.setForeground(DARK);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        field.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(label);
        panel.add(Box.createVerticalStrut(6));
        panel.add(field);
        panel.add(Box.createVerticalStrut(14));
    }

    private void addFooter(JPanel outer) {
        JLabel footer = new JLabel(
                "CampusConnect | College Event Management System",
                SwingConstants.CENTER);
        footer.setForeground(Color.GRAY);
        footer.setBorder(new EmptyBorder(12, 10, 15, 10));
        outer.add(footer, BorderLayout.SOUTH);
    }

    // ---------- 1. ROLE SELECTION ----------

    private void showRoleSelection() {
        JPanel outer = createOuterPage();
        addHeader(outer, "WELCOME");

        JPanel card = createCard(
                "Welcome to CampusConnect",
                "Choose how you want to continue");

        card.setPreferredSize(new Dimension(590, 400));

        addButton(card, "STUDENT",
                BLUE, () -> {
                    role = "Student";
                    showLogin();
                });

        addButton(card, "ORGANIZER",
                GREEN, () -> {
                    role = "Organizer";
                    showLogin();
                });

        addButton(card, "SIGN UP",
                LIGHT_BLUE, this::showSignup);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 2. LOGIN ----------

    private void showLogin() {
        JPanel outer = createOuterPage();
        addHeader(outer, role.toUpperCase() + " LOGIN");

        JPanel card = createCard(
                role + " Login",
                "Enter your details to continue");

        card.setPreferredSize(new Dimension(520, 420));

        loginUsername = createField("Enter username");
        loginPassword = new JPasswordField();
        loginPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
        loginPassword.setMaximumSize(new Dimension(420, 38));
        loginPassword.setPreferredSize(new Dimension(420, 38));

        addField(card, "Username", loginUsername);
        addField(card, "Password", loginPassword);

        addButton(card, "LOGIN", BLUE, () -> {
            String entered = loginUsername.getText().trim();

            if (entered.isEmpty()) {
                entered = role + " Demo";
            }

            username = entered;

            if (role.equals("Student")) {
                showStudentDashboard();
            } else {
                showOrganizerDashboard();
            }
        });

        addButton(card, "CREATE NEW ACCOUNT",
                LIGHT_BLUE, this::showSignup);

        addButton(card, "BACK",
                LIGHT_BLUE, this::showRoleSelection);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 3. FULL STUDENT SIGNUP ----------

    private void showSignup() {
        JPanel outer = createOuterPage();
        addHeader(outer, "STUDENT REGISTRATION");

        JPanel card = createCard(
                "Create Student Account",
                "Fill in all your student details");

        card.setPreferredSize(new Dimension(600, 900));

        JTextField name = createField("Enter full name");
        JTextField roll = createField("Enter roll number");
        JTextField college = createField("Enter college name");
        JTextField email = createField("Enter email address");
        JTextField phone = createField("Enter phone number");
        JTextField user = createField("Create username");

        JPasswordField password = new JPasswordField();
        password.setMaximumSize(new Dimension(420, 38));
        password.setPreferredSize(new Dimension(420, 38));

        addField(card, "Full Name", name);
        addField(card, "Roll Number", roll);

        JLabel departmentLabel = new JLabel("Department");
        departmentLabel.setFont(
                new Font("SansSerif", Font.BOLD, 13));
        departmentLabel.setForeground(DARK);
        departmentLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(departmentLabel);
        card.add(Box.createVerticalStrut(8));

        JPanel departmentPanel = new JPanel(
                new GridLayout(0, 2, 8, 6));
        departmentPanel.setBackground(WHITE);
        departmentPanel.setMaximumSize(
                new Dimension(420, 125));

        JCheckBox cs = new JCheckBox("Computer Science");
        JCheckBox mechanical = new JCheckBox("Mechanical");
        JCheckBox electronics = new JCheckBox("Electronics");
        JCheckBox electrical = new JCheckBox("Electrical");
        JCheckBox civil = new JCheckBox("Civil");

        JCheckBox[] departments = {
            cs, mechanical, electronics, electrical, civil
        };

        for (JCheckBox check : departments) {
            check.setBackground(WHITE);
            check.setFont(
                    new Font("SansSerif", Font.PLAIN, 13));
            departmentPanel.add(check);
        }

        card.add(departmentPanel);
        card.add(Box.createVerticalStrut(16));

        JLabel semesterLabel = new JLabel("Semester");
        semesterLabel.setFont(
                new Font("SansSerif", Font.BOLD, 13));
        semesterLabel.setForeground(DARK);
        semesterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(semesterLabel);
        card.add(Box.createVerticalStrut(6));

        JComboBox<String> semester = new JComboBox<>(
                new String[]{
                    "S1", "S2", "S3", "S4",
                    "S5", "S6", "S7", "S8"
                });

        semester.setFont(
                new Font("SansSerif", Font.PLAIN, 14));
        semester.setMaximumSize(new Dimension(420, 38));
        semester.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(semester);
        card.add(Box.createVerticalStrut(16));

        addField(card, "College Name", college);
        addField(card, "Email ID", email);
        addField(card, "Phone Number", phone);
        addField(card, "Username", user);
        addField(card, "Password", password);

        addButton(card, "SUBMIT SIGN UP", BLUE, () -> {

            if (name.getText().trim().isEmpty()
                    || roll.getText().trim().isEmpty()
                    || college.getText().trim().isEmpty()
                    || email.getText().trim().isEmpty()
                    || phone.getText().trim().isEmpty()
                    || user.getText().trim().isEmpty()
                    || password.getPassword().length == 0) {

                JOptionPane.showMessageDialog(this,
                        "Please fill in all fields.");
                return;
            }

            String department = "";

            if (cs.isSelected())
                department += "Computer Science, ";
            if (mechanical.isSelected())
                department += "Mechanical, ";
            if (electronics.isSelected())
                department += "Electronics, ";
            if (electrical.isSelected())
                department += "Electrical, ";
            if (civil.isSelected())
                department += "Civil, ";

            if (department.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please select a department.");
                return;
            }

            registeredName = name.getText().trim();
            registeredRoll = roll.getText().trim();
            registeredDepartment = department;
            registeredSemester =
                    semester.getSelectedItem().toString();
            registeredCollege = college.getText().trim();
            registeredEmail = email.getText().trim();
            registeredPhone = phone.getText().trim();
            registeredUsername = user.getText().trim();
            registeredPassword =
                    new String(password.getPassword());

            username = registeredName;
            role = "Student";

            JOptionPane.showMessageDialog(this,
                    "Student registration successful!");

            showStudentDashboard();
        });

        addButton(card, "BACK TO LOGIN",
                LIGHT_BLUE, this::showLogin);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 4. STUDENT DASHBOARD ----------

    private void showStudentDashboard() {
        JPanel outer = createOuterPage();
        addHeader(outer, "STUDENT PORTAL");

        JPanel card = createCard(
                "Hello, " + username + "!",
                "Welcome to your student dashboard");

        card.setPreferredSize(new Dimension(570, 510));

        addButton(card, "Explore Events",
                BLUE, this::showEvents);

        addButton(card, "My Registrations",
                LIGHT_BLUE, this::showMyRegistrations);

        addButton(card, "My Profile",
                LIGHT_BLUE, this::showProfile);

        addButton(card, "Logout",
                new Color(190, 55, 70),
                this::showRoleSelection);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 5. ORGANIZER DASHBOARD ----------

    private void showOrganizerDashboard() {
        JPanel outer = createOuterPage();
        addHeader(outer, "ORGANIZER PORTAL");

        JPanel card = createCard(
                "Organizer Dashboard",
                "Manage your college events");

        card.setPreferredSize(new Dimension(570, 510));

        addButton(card, "Create New Event",
                GREEN, this::showCreateEvent);

        addButton(card, "Manage Events",
                BLUE, this::showEvents);

        addButton(card, "View Participants",
                LIGHT_BLUE, this::showParticipants);

        addButton(card, "View Reports",
                LIGHT_BLUE, this::showReport);

        addButton(card, "Logout",
                new Color(190, 55, 70),
                this::showRoleSelection);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 6. EVENTS ----------

    private void showEvents() {
        JPanel outer = createOuterPage();
        addHeader(outer, "EVENTS");

        JPanel card = createCard(
                "Available Events",
                "Explore events happening on campus");

        card.setPreferredSize(new Dimension(580, 500));

        if (eventList.isEmpty()) {
            JLabel empty = new JLabel("No events available.");
            empty.setAlignmentX(Component.CENTER_ALIGNMENT);
            card.add(empty);
            card.add(Box.createVerticalStrut(20));
        }

        for (String event : eventList) {
            JButton eventButton = createButton(event, LIGHT_BLUE);

            eventButton.addActionListener(e -> {
                eventName = event;
                showEventDetails();
            });

            card.add(eventButton);
            card.add(Box.createVerticalStrut(10));
        }

        if (role.equals("Student")) {
            addButton(card, "Register for Selected Event",
                    GREEN, this::showRegister);
        }

        addButton(card, "Back to Dashboard",
                LIGHT_BLUE, this::goDashboard);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 7. EVENT DETAILS ----------

    private void showEventDetails() {
        JPanel outer = createOuterPage();
        addHeader(outer, "EVENT DETAILS");

        JPanel card = createCard(
                eventName,
                "Event information");

        card.setPreferredSize(new Dimension(570, 460));

        JLabel details = new JLabel(
                "<html><div style='text-align:center'>"
                + "<b>Description:</b><br>"
                + eventDescription + "<br><br>"
                + "<b>Date:</b><br>" + eventDate + "<br><br>"
                + "<b>Venue:</b><br>" + eventVenue
                + "</div></html>");

        details.setFont(new Font("SansSerif", Font.PLAIN, 15));
        details.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(details);
        card.add(Box.createVerticalStrut(25));

        if (role.equals("Student")) {
            addButton(card, "Register Now",
                    GREEN, this::showRegister);
        }

        addButton(card, "Back to Events",
                LIGHT_BLUE, this::showEvents);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 8. STUDENT REGISTRATION FOR EVENT ----------

    private void showRegister() {
        JPanel outer = createOuterPage();
        addHeader(outer, "EVENT REGISTRATION");

        JPanel card = createCard(
                "Register for Event",
                "Submit your registration details");

        card.setPreferredSize(new Dimension(550, 420));

        JTextField name = createField("Student name");
        name.setText(username);

        JLabel eventLabel = new JLabel("Selected Event: " + eventName);
        eventLabel.setFont(
                new Font("SansSerif", Font.BOLD, 14));
        eventLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        addField(card, "Student Name", name);
        card.add(eventLabel);
        card.add(Box.createVerticalStrut(22));

        addButton(card, "SUBMIT REGISTRATION", GREEN, () -> {
            if (name.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter your name.");
                return;
            }

            String participant = name.getText().trim()
                    + " - " + eventName;

            if (!participants.contains(participant)) {
                participants.add(participant);
            }

            registeredName = name.getText().trim();

            JOptionPane.showMessageDialog(this,
                    "Registration submitted successfully!");

            showMyRegistrations();
        });

        addButton(card, "Back to Events",
                LIGHT_BLUE, this::showEvents);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 9. MY REGISTRATIONS ----------

    private void showMyRegistrations() {
        JPanel outer = createOuterPage();
        addHeader(outer, "MY REGISTRATIONS");

        JPanel card = createCard(
                "My Registrations",
                "Your event registration information");

        card.setPreferredSize(new Dimension(580, 470));

        boolean found = false;

        for (String participant : participants) {
            if (participant.startsWith(username + " - ")) {
                JLabel item = new JLabel(participant);
                item.setFont(
                        new Font("SansSerif", Font.PLAIN, 14));
                item.setAlignmentX(Component.CENTER_ALIGNMENT);
                card.add(item);
                card.add(Box.createVerticalStrut(12));
                found = true;
            }
        }

        if (!found) {
            JLabel empty = new JLabel(
                    "No registrations found for this username.");
            empty.setAlignmentX(Component.CENTER_ALIGNMENT);
            card.add(empty);
            card.add(Box.createVerticalStrut(20));
        }

        addButton(card, "Back to Dashboard",
                LIGHT_BLUE, this::showStudentDashboard);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 10. STUDENT PROFILE ----------

    private void showProfile() {
        JPanel outer = createOuterPage();
        addHeader(outer, "MY PROFILE");

        JPanel card = createCard(
                "Student Profile",
                "Your saved signup details");

        card.setPreferredSize(new Dimension(580, 570));

        String details =
                "<html><div style='text-align:center'>"
                + "<b>Name:</b> " + safe(registeredName) + "<br><br>"
                + "<b>Roll Number:</b> " + safe(registeredRoll) + "<br><br>"
                + "<b>Department:</b> " + safe(registeredDepartment) + "<br><br>"
                + "<b>Semester:</b> " + safe(registeredSemester) + "<br><br>"
                + "<b>College:</b> " + safe(registeredCollege) + "<br><br>"
                + "<b>Email:</b> " + safe(registeredEmail) + "<br><br>"
                + "<b>Phone:</b> " + safe(registeredPhone)
                + "</div></html>";

        JLabel info = new JLabel(details);
        info.setFont(new Font("SansSerif", Font.PLAIN, 14));
        info.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(info);
        card.add(Box.createVerticalStrut(25));

        addButton(card, "Back to Dashboard",
                LIGHT_BLUE, this::showStudentDashboard);

        addFooter(outer);
        displayCard(outer, card);
    }

    private String safe(String value) {
        return value == null || value.isEmpty()
                ? "Not provided" : value;
    }

    // ---------- 11. CREATE EVENT ----------

    private void showCreateEvent() {
        JPanel outer = createOuterPage();
        addHeader(outer, "CREATE EVENT");

        JPanel card = createCard(
                "Create New Event",
                "Enter the new event details");

        card.setPreferredSize(new Dimension(580, 560));

        JTextField name = createField("Event name");
        JTextField date = createField("Event date");
        JTextField venue = createField("Event venue");
        JTextField description = createField("Event description");

        addField(card, "Event Name", name);
        addField(card, "Event Date", date);
        addField(card, "Event Venue", venue);
        addField(card, "Description", description);

        addButton(card, "CREATE EVENT", GREEN, () -> {
            if (name.getText().trim().isEmpty()
                    || date.getText().trim().isEmpty()
                    || venue.getText().trim().isEmpty()
                    || description.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Please fill in all event fields.");
                return;
            }

            eventName = name.getText().trim();
            eventDate = date.getText().trim();
            eventVenue = venue.getText().trim();
            eventDescription = description.getText().trim();

            if (!eventList.contains(eventName)) {
                eventList.add(eventName);
            }

            JOptionPane.showMessageDialog(this,
                    "Event created successfully!");

            showOrganizerDashboard();
        });

        addButton(card, "Back to Dashboard",
                LIGHT_BLUE, this::showOrganizerDashboard);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 12. PARTICIPANTS ----------

    private void showParticipants() {
        JPanel outer = createOuterPage();
        addHeader(outer, "PARTICIPANTS");

        JPanel card = createCard(
                "Event Participants",
                "Student registration list");

        card.setPreferredSize(new Dimension(600, 500));

        if (participants.isEmpty()) {
            JLabel empty = new JLabel("No participants registered yet.");
            empty.setAlignmentX(Component.CENTER_ALIGNMENT);
            card.add(empty);
            card.add(Box.createVerticalStrut(20));
        } else {
            for (String person : participants) {
                JLabel item = new JLabel(person);
                item.setFont(
                        new Font("SansSerif", Font.PLAIN, 14));
                item.setAlignmentX(Component.CENTER_ALIGNMENT);

                card.add(item);
                card.add(Box.createVerticalStrut(12));
            }
        }

        addButton(card, "Back to Dashboard",
                LIGHT_BLUE, this::showOrganizerDashboard);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 13. REPORT ----------

    private void showReport() {
        JPanel outer = createOuterPage();
        addHeader(outer, "REPORTS");

        JPanel card = createCard(
                "Event Report",
                "Current event summary");

        card.setPreferredSize(new Dimension(580, 450));

        JLabel report = new JLabel(
                "<html><div style='text-align:center'>"
                + "<b>Total Events:</b> " + eventList.size() + "<br><br>"
                + "<b>Total Registrations:</b> "
                + participants.size() + "<br><br>"
                + "<b>Latest Event:</b> " + eventName + "<br><br>"
                + "<b>Event Date:</b> " + eventDate + "<br><br>"
                + "<b>Venue:</b> " + eventVenue
                + "</div></html>");

        report.setFont(new Font("SansSerif", Font.PLAIN, 15));
        report.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(report);
        card.add(Box.createVerticalStrut(25));

        addButton(card, "Back to Dashboard",
                LIGHT_BLUE, this::showOrganizerDashboard);

        addFooter(outer);
        displayCard(outer, card);
    }

    private void goDashboard() {
        if (role.equals("Student")) {
            showStudentDashboard();
        } else {
            showOrganizerDashboard();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(campusconnect::new);
    }
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class campusconnect extends JFrame {

    private final Color BG = new Color(241, 245, 252);
    private final Color BLUE = new Color(48, 83, 210);
    private final Color DARK = new Color(28, 40, 75);
    private final Color GREEN = new Color(15, 145, 115);
    private final Color WHITE = Color.WHITE;
    private final Color LIGHT_BLUE = new Color(232, 237, 255);

    private JPanel main;

    private String role = "Student";
    private String username = "Student";

    private String registeredName = "";
    private String registeredRoll = "";
    private String registeredDepartment = "";
    private String registeredSemester = "";
    private String registeredCollege = "";
    private String registeredEmail = "";
    private String registeredPhone = "";
    private String registeredUsername = "";
    private String registeredPassword = "";

    private String eventName = "Tech Fest 2026";
    private String eventDescription =
            "Technology exhibitions and coding activities";
    private String eventDate = "10 November 2026";
    private String eventVenue = "College Auditorium";

    private final ArrayList<String> participants =
            new ArrayList<>();

    private final ArrayList<String> eventList =
            new ArrayList<>();

    private JTextField loginUsername;
    private JPasswordField loginPassword;

    public campusconnect() {
        setTitle("CampusConnect - College Event Portal");
        setSize(950, 700);
        setMinimumSize(new Dimension(750, 550));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        main = new JPanel(new BorderLayout());
        main.setBackground(BG);

        setContentPane(main);

        eventList.add(eventName);

        showRoleSelection();
        setVisible(true);
    }

    // ---------- COMMON DESIGN ----------

    private void showPage(JPanel page) {
        main.removeAll();
        main.add(page, BorderLayout.CENTER);
        main.revalidate();
        main.repaint();
    }

    private JPanel createOuterPage() {
        JPanel outer = new JPanel(new BorderLayout());
        outer.setBackground(BG);
        return outer;
    }

    private void addHeader(JPanel outer, String section) {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(DARK);
        header.setBorder(new EmptyBorder(18, 30, 18, 30));

        JLabel logo = new JLabel("CAMPUSCONNECT");
        logo.setForeground(WHITE);
        logo.setFont(new Font("SansSerif", Font.BOLD, 22));

        JLabel label = new JLabel(section);
        label.setForeground(new Color(210, 220, 255));
        label.setFont(new Font("SansSerif", Font.PLAIN, 13));

        header.add(logo, BorderLayout.WEST);
        header.add(label, BorderLayout.EAST);

        outer.add(header, BorderLayout.NORTH);
    }

    private JPanel createCard(String heading, String subtitle) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(WHITE);
        card.setBorder(new EmptyBorder(30, 35, 30, 35));

        JLabel title = new JLabel(heading);
        title.setFont(new Font("SansSerif", Font.BOLD, 27));
        title.setForeground(DARK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel description = new JLabel(subtitle);
        description.setFont(new Font("SansSerif", Font.PLAIN, 14));
        description.setForeground(Color.GRAY);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(title);
        card.add(Box.createVerticalStrut(10));
        card.add(description);
        card.add(Box.createVerticalStrut(25));

        return card;
    }

    private void displayCard(JPanel outer, JPanel card) {
        JPanel center = new JPanel(new GridBagLayout());
        center.setBackground(BG);
        center.setBorder(new EmptyBorder(20, 20, 20, 20));
        center.add(card);

        JScrollPane scroll = new JScrollPane(center);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.getViewport().setBackground(BG);

        outer.add(scroll, BorderLayout.CENTER);
        showPage(outer);
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(color);
        button.setForeground(color.equals(LIGHT_BLUE) ? BLUE : WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(400, 44));
        button.setPreferredSize(new Dimension(400, 44));
        return button;
    }

    private void addButton(JPanel panel, String text,
                           Color color, Runnable action) {
        JButton button = createButton(text, color);
        button.addActionListener(e -> action.run());

        panel.add(button);
        panel.add(Box.createVerticalStrut(12));
    }

    private JTextField createField(String hint) {
        JTextField field = new JTextField();
        field.setFont(new Font("SansSerif", Font.PLAIN, 14));
        field.setMaximumSize(new Dimension(420, 38));
        field.setPreferredSize(new Dimension(420, 38));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        new Color(215, 222, 237)),
                new EmptyBorder(8, 12, 8, 12)));
        field.setToolTipText(hint);
        return field;
    }

    private void addField(JPanel panel, String name,
                          JTextField field) {
        JLabel label = new JLabel(name);
        label.setFont(new Font("SansSerif", Font.BOLD, 13));
        label.setForeground(DARK);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        field.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(label);
        panel.add(Box.createVerticalStrut(6));
        panel.add(field);
        panel.add(Box.createVerticalStrut(14));
    }

    private void addFooter(JPanel outer) {
        JLabel footer = new JLabel(
                "CampusConnect | College Event Management System",
                SwingConstants.CENTER);
        footer.setForeground(Color.GRAY);
        footer.setBorder(new EmptyBorder(12, 10, 15, 10));
        outer.add(footer, BorderLayout.SOUTH);
    }

    // ---------- 1. ROLE SELECTION ----------

    private void showRoleSelection() {
        JPanel outer = createOuterPage();
        addHeader(outer, "WELCOME");

        JPanel card = createCard(
                "Welcome to CampusConnect",
                "Choose how you want to continue");

        card.setPreferredSize(new Dimension(590, 400));

        addButton(card, "STUDENT",
                BLUE, () -> {
                    role = "Student";
                    showLogin();
                });

        addButton(card, "ORGANIZER",
                GREEN, () -> {
                    role = "Organizer";
                    showLogin();
                });

        addButton(card, "SIGN UP",
                LIGHT_BLUE, this::showSignup);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 2. LOGIN ----------

    private void showLogin() {
        JPanel outer = createOuterPage();
        addHeader(outer, role.toUpperCase() + " LOGIN");

        JPanel card = createCard(
                role + " Login",
                "Enter your details to continue");

        card.setPreferredSize(new Dimension(520, 420));

        loginUsername = createField("Enter username");
        loginPassword = new JPasswordField();
        loginPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
        loginPassword.setMaximumSize(new Dimension(420, 38));
        loginPassword.setPreferredSize(new Dimension(420, 38));

        addField(card, "Username", loginUsername);
        addField(card, "Password", loginPassword);

        addButton(card, "LOGIN", BLUE, () -> {
            String entered = loginUsername.getText().trim();

            if (entered.isEmpty()) {
                entered = role + " Demo";
            }

            username = entered;

            if (role.equals("Student")) {
                showStudentDashboard();
            } else {
                showOrganizerDashboard();
            }
        });

        addButton(card, "CREATE NEW ACCOUNT",
                LIGHT_BLUE, this::showSignup);

        addButton(card, "BACK",
                LIGHT_BLUE, this::showRoleSelection);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 3. FULL STUDENT SIGNUP ----------

    private void showSignup() {
        JPanel outer = createOuterPage();
        addHeader(outer, "STUDENT REGISTRATION");

        JPanel card = createCard(
                "Create Student Account",
                "Fill in all your student details");

        card.setPreferredSize(new Dimension(600, 900));

        JTextField name = createField("Enter full name");
        JTextField roll = createField("Enter roll number");
        JTextField college = createField("Enter college name");
        JTextField email = createField("Enter email address");
        JTextField phone = createField("Enter phone number");
        JTextField user = createField("Create username");

        JPasswordField password = new JPasswordField();
        password.setMaximumSize(new Dimension(420, 38));
        password.setPreferredSize(new Dimension(420, 38));

        addField(card, "Full Name", name);
        addField(card, "Roll Number", roll);

        JLabel departmentLabel = new JLabel("Department");
        departmentLabel.setFont(
                new Font("SansSerif", Font.BOLD, 13));
        departmentLabel.setForeground(DARK);
        departmentLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(departmentLabel);
        card.add(Box.createVerticalStrut(8));

        JPanel departmentPanel = new JPanel(
                new GridLayout(0, 2, 8, 6));
        departmentPanel.setBackground(WHITE);
        departmentPanel.setMaximumSize(
                new Dimension(420, 125));

        JCheckBox cs = new JCheckBox("Computer Science");
        JCheckBox mechanical = new JCheckBox("Mechanical");
        JCheckBox electronics = new JCheckBox("Electronics");
        JCheckBox electrical = new JCheckBox("Electrical");
        JCheckBox civil = new JCheckBox("Civil");

        JCheckBox[] departments = {
            cs, mechanical, electronics, electrical, civil
        };

        for (JCheckBox check : departments) {
            check.setBackground(WHITE);
            check.setFont(
                    new Font("SansSerif", Font.PLAIN, 13));
            departmentPanel.add(check);
        }

        card.add(departmentPanel);
        card.add(Box.createVerticalStrut(16));

        JLabel semesterLabel = new JLabel("Semester");
        semesterLabel.setFont(
                new Font("SansSerif", Font.BOLD, 13));
        semesterLabel.setForeground(DARK);
        semesterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(semesterLabel);
        card.add(Box.createVerticalStrut(6));

        JComboBox<String> semester = new JComboBox<>(
                new String[]{
                    "S1", "S2", "S3", "S4",
                    "S5", "S6", "S7", "S8"
                });

        semester.setFont(
                new Font("SansSerif", Font.PLAIN, 14));
        semester.setMaximumSize(new Dimension(420, 38));
        semester.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(semester);
        card.add(Box.createVerticalStrut(16));

        addField(card, "College Name", college);
        addField(card, "Email ID", email);
        addField(card, "Phone Number", phone);
        addField(card, "Username", user);
        addField(card, "Password", password);

        addButton(card, "SUBMIT SIGN UP", BLUE, () -> {

            if (name.getText().trim().isEmpty()
                    || roll.getText().trim().isEmpty()
                    || college.getText().trim().isEmpty()
                    || email.getText().trim().isEmpty()
                    || phone.getText().trim().isEmpty()
                    || user.getText().trim().isEmpty()
                    || password.getPassword().length == 0) {

                JOptionPane.showMessageDialog(this,
                        "Please fill in all fields.");
                return;
            }

            String department = "";

            if (cs.isSelected())
                department += "Computer Science, ";
            if (mechanical.isSelected())
                department += "Mechanical, ";
            if (electronics.isSelected())
                department += "Electronics, ";
            if (electrical.isSelected())
                department += "Electrical, ";
            if (civil.isSelected())
                department += "Civil, ";

            if (department.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please select a department.");
                return;
            }

            registeredName = name.getText().trim();
            registeredRoll = roll.getText().trim();
            registeredDepartment = department;
            registeredSemester =
                    semester.getSelectedItem().toString();
            registeredCollege = college.getText().trim();
            registeredEmail = email.getText().trim();
            registeredPhone = phone.getText().trim();
            registeredUsername = user.getText().trim();
            registeredPassword =
                    new String(password.getPassword());

            username = registeredName;
            role = "Student";

            JOptionPane.showMessageDialog(this,
                    "Student registration successful!");

            showStudentDashboard();
        });

        addButton(card, "BACK TO LOGIN",
                LIGHT_BLUE, this::showLogin);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 4. STUDENT DASHBOARD ----------

    private void showStudentDashboard() {
        JPanel outer = createOuterPage();
        addHeader(outer, "STUDENT PORTAL");

        JPanel card = createCard(
                "Hello, " + username + "!",
                "Welcome to your student dashboard");

        card.setPreferredSize(new Dimension(570, 510));

        addButton(card, "Explore Events",
                BLUE, this::showEvents);

        addButton(card, "My Registrations",
                LIGHT_BLUE, this::showMyRegistrations);

        addButton(card, "My Profile",
                LIGHT_BLUE, this::showProfile);

        addButton(card, "Logout",
                new Color(190, 55, 70),
                this::showRoleSelection);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 5. ORGANIZER DASHBOARD ----------

    private void showOrganizerDashboard() {
        JPanel outer = createOuterPage();
        addHeader(outer, "ORGANIZER PORTAL");

        JPanel card = createCard(
                "Organizer Dashboard",
                "Manage your college events");

        card.setPreferredSize(new Dimension(570, 510));

        addButton(card, "Create New Event",
                GREEN, this::showCreateEvent);

        addButton(card, "Manage Events",
                BLUE, this::showEvents);

        addButton(card, "View Participants",
                LIGHT_BLUE, this::showParticipants);

        addButton(card, "View Reports",
                LIGHT_BLUE, this::showReport);

        addButton(card, "Logout",
                new Color(190, 55, 70),
                this::showRoleSelection);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 6. EVENTS ----------

    private void showEvents() {
        JPanel outer = createOuterPage();
        addHeader(outer, "EVENTS");

        JPanel card = createCard(
                "Available Events",
                "Explore events happening on campus");

        card.setPreferredSize(new Dimension(580, 500));

        if (eventList.isEmpty()) {
            JLabel empty = new JLabel("No events available.");
            empty.setAlignmentX(Component.CENTER_ALIGNMENT);
            card.add(empty);
            card.add(Box.createVerticalStrut(20));
        }

        for (String event : eventList) {
            JButton eventButton = createButton(event, LIGHT_BLUE);

            eventButton.addActionListener(e -> {
                eventName = event;
                showEventDetails();
            });

            card.add(eventButton);
            card.add(Box.createVerticalStrut(10));
        }

        if (role.equals("Student")) {
            addButton(card, "Register for Selected Event",
                    GREEN, this::showRegister);
        }

        addButton(card, "Back to Dashboard",
                LIGHT_BLUE, this::goDashboard);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 7. EVENT DETAILS ----------

    private void showEventDetails() {
        JPanel outer = createOuterPage();
        addHeader(outer, "EVENT DETAILS");

        JPanel card = createCard(
                eventName,
                "Event information");

        card.setPreferredSize(new Dimension(570, 460));

        JLabel details = new JLabel(
                "<html><div style='text-align:center'>"
                + "<b>Description:</b><br>"
                + eventDescription + "<br><br>"
                + "<b>Date:</b><br>" + eventDate + "<br><br>"
                + "<b>Venue:</b><br>" + eventVenue
                + "</div></html>");

        details.setFont(new Font("SansSerif", Font.PLAIN, 15));
        details.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(details);
        card.add(Box.createVerticalStrut(25));

        if (role.equals("Student")) {
            addButton(card, "Register Now",
                    GREEN, this::showRegister);
        }

        addButton(card, "Back to Events",
                LIGHT_BLUE, this::showEvents);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 8. STUDENT REGISTRATION FOR EVENT ----------

    private void showRegister() {
        JPanel outer = createOuterPage();
        addHeader(outer, "EVENT REGISTRATION");

        JPanel card = createCard(
                "Register for Event",
                "Submit your registration details");

        card.setPreferredSize(new Dimension(550, 420));

        JTextField name = createField("Student name");
        name.setText(username);

        JLabel eventLabel = new JLabel("Selected Event: " + eventName);
        eventLabel.setFont(
                new Font("SansSerif", Font.BOLD, 14));
        eventLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        addField(card, "Student Name", name);
        card.add(eventLabel);
        card.add(Box.createVerticalStrut(22));

        addButton(card, "SUBMIT REGISTRATION", GREEN, () -> {
            if (name.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter your name.");
                return;
            }

            String participant = name.getText().trim()
                    + " - " + eventName;

            if (!participants.contains(participant)) {
                participants.add(participant);
            }

            registeredName = name.getText().trim();

            JOptionPane.showMessageDialog(this,
                    "Registration submitted successfully!");

            showMyRegistrations();
        });

        addButton(card, "Back to Events",
                LIGHT_BLUE, this::showEvents);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 9. MY REGISTRATIONS ----------

    private void showMyRegistrations() {
        JPanel outer = createOuterPage();
        addHeader(outer, "MY REGISTRATIONS");

        JPanel card = createCard(
                "My Registrations",
                "Your event registration information");

        card.setPreferredSize(new Dimension(580, 470));

        boolean found = false;

        for (String participant : participants) {
            if (participant.startsWith(username + " - ")) {
                JLabel item = new JLabel(participant);
                item.setFont(
                        new Font("SansSerif", Font.PLAIN, 14));
                item.setAlignmentX(Component.CENTER_ALIGNMENT);
                card.add(item);
                card.add(Box.createVerticalStrut(12));
                found = true;
            }
        }

        if (!found) {
            JLabel empty = new JLabel(
                    "No registrations found for this username.");
            empty.setAlignmentX(Component.CENTER_ALIGNMENT);
            card.add(empty);
            card.add(Box.createVerticalStrut(20));
        }

        addButton(card, "Back to Dashboard",
                LIGHT_BLUE, this::showStudentDashboard);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 10. STUDENT PROFILE ----------

    private void showProfile() {
        JPanel outer = createOuterPage();
        addHeader(outer, "MY PROFILE");

        JPanel card = createCard(
                "Student Profile",
                "Your saved signup details");

        card.setPreferredSize(new Dimension(580, 570));

        String details =
                "<html><div style='text-align:center'>"
                + "<b>Name:</b> " + safe(registeredName) + "<br><br>"
                + "<b>Roll Number:</b> " + safe(registeredRoll) + "<br><br>"
                + "<b>Department:</b> " + safe(registeredDepartment) + "<br><br>"
                + "<b>Semester:</b> " + safe(registeredSemester) + "<br><br>"
                + "<b>College:</b> " + safe(registeredCollege) + "<br><br>"
                + "<b>Email:</b> " + safe(registeredEmail) + "<br><br>"
                + "<b>Phone:</b> " + safe(registeredPhone)
                + "</div></html>";

        JLabel info = new JLabel(details);
        info.setFont(new Font("SansSerif", Font.PLAIN, 14));
        info.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(info);
        card.add(Box.createVerticalStrut(25));

        addButton(card, "Back to Dashboard",
                LIGHT_BLUE, this::showStudentDashboard);

        addFooter(outer);
        displayCard(outer, card);
    }

    private String safe(String value) {
        return value == null || value.isEmpty()
                ? "Not provided" : value;
    }

    // ---------- 11. CREATE EVENT ----------

    private void showCreateEvent() {
        JPanel outer = createOuterPage();
        addHeader(outer, "CREATE EVENT");

        JPanel card = createCard(
                "Create New Event",
                "Enter the new event details");

        card.setPreferredSize(new Dimension(580, 560));

        JTextField name = createField("Event name");
        JTextField date = createField("Event date");
        JTextField venue = createField("Event venue");
        JTextField description = createField("Event description");

        addField(card, "Event Name", name);
        addField(card, "Event Date", date);
        addField(card, "Event Venue", venue);
        addField(card, "Description", description);

        addButton(card, "CREATE EVENT", GREEN, () -> {
            if (name.getText().trim().isEmpty()
                    || date.getText().trim().isEmpty()
                    || venue.getText().trim().isEmpty()
                    || description.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Please fill in all event fields.");
                return;
            }

            eventName = name.getText().trim();
            eventDate = date.getText().trim();
            eventVenue = venue.getText().trim();
            eventDescription = description.getText().trim();

            if (!eventList.contains(eventName)) {
                eventList.add(eventName);
            }

            JOptionPane.showMessageDialog(this,
                    "Event created successfully!");

            showOrganizerDashboard();
        });

        addButton(card, "Back to Dashboard",
                LIGHT_BLUE, this::showOrganizerDashboard);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 12. PARTICIPANTS ----------

    private void showParticipants() {
        JPanel outer = createOuterPage();
        addHeader(outer, "PARTICIPANTS");

        JPanel card = createCard(
                "Event Participants",
                "Student registration list");

        card.setPreferredSize(new Dimension(600, 500));

        if (participants.isEmpty()) {
            JLabel empty = new JLabel("No participants registered yet.");
            empty.setAlignmentX(Component.CENTER_ALIGNMENT);
            card.add(empty);
            card.add(Box.createVerticalStrut(20));
        } else {
            for (String person : participants) {
                JLabel item = new JLabel(person);
                item.setFont(
                        new Font("SansSerif", Font.PLAIN, 14));
                item.setAlignmentX(Component.CENTER_ALIGNMENT);

                card.add(item);
                card.add(Box.createVerticalStrut(12));
            }
        }

        addButton(card, "Back to Dashboard",
                LIGHT_BLUE, this::showOrganizerDashboard);

        addFooter(outer);
        displayCard(outer, card);
    }

    // ---------- 13. REPORT ----------

    private void showReport() {
        JPanel outer = createOuterPage();
        addHeader(outer, "REPORTS");

        JPanel card = createCard(
                "Event Report",
                "Current event summary");

        card.setPreferredSize(new Dimension(580, 450));

        JLabel report = new JLabel(
                "<html><div style='text-align:center'>"
                + "<b>Total Events:</b> " + eventList.size() + "<br><br>"
                + "<b>Total Registrations:</b> "
                + participants.size() + "<br><br>"
                + "<b>Latest Event:</b> " + eventName + "<br><br>"
                + "<b>Event Date:</b> " + eventDate + "<br><br>"
                + "<b>Venue:</b> " + eventVenue
                + "</div></html>");

        report.setFont(new Font("SansSerif", Font.PLAIN, 15));
        report.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(report);
        card.add(Box.createVerticalStrut(25));

        addButton(card, "Back to Dashboard",
                LIGHT_BLUE, this::showOrganizerDashboard);

        addFooter(outer);
        displayCard(outer, card);
    }

    private void goDashboard() {
        if (role.equals("Student")) {
            showStudentDashboard();
        } else {
            showOrganizerDashboard();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(campusconnect::new);
    }

}