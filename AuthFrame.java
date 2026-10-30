
import javax.swing.*;
import java.awt.*;

public class AuthFrame extends BaseFrame {
    private final String role;

    private JTextField loginUsername;
    private JPasswordField loginPassword;

    private JTextField nameField, emailField, phoneField;
    private JTextField organizationField, usernameField;
    private JPasswordField passwordField, confirmField;

    private JRadioButton[] departmentButtons;
    private JComboBox<String> semesterBox;

    public AuthFrame(String role) {
        super("CampusConnect - " + role);
        this.role = role;

        JPanel page = createPage(
            role + " Portal",
            "Login or create your " + role.toLowerCase() + " account"
        );

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Login", createLoginPanel());
        tabs.addTab("Sign Up", createSignupPanel());

        page.add(tabs, BorderLayout.CENTER);

        JButton back = createButton("Back to Role Selection");
        back.addActionListener(e -> {
            new RoleSelectionFrame().setVisible(true);
            dispose();
        });

        page.add(back, BorderLayout.SOUTH);
        setContentPane(page);
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 12));
        panel.setBackground(BG);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 10, 25, 10));

        loginUsername = new JTextField();
        loginPassword = new JPasswordField();
        JButton login = createButton("Login");

        panel.add(new JLabel("Username"));
        panel.add(loginUsername);
        panel.add(new JLabel("Password"));
        panel.add(loginPassword);
        panel.add(new JLabel(""));
        panel.add(login);

        login.addActionListener(e -> loginAccount());
        return panel;
    }

    private JScrollPane createSignupPanel() {
        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.setBackground(BG);
        form.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        confirmField = new JPasswordField();

        addRow(form, "Full Name", nameField);
        addRow(form, "Email", emailField);
        addRow(form, "Phone Number", phoneField);

        if (role.equals("Student")) {
            JRadioButton cse = new JRadioButton("CSE");
            JRadioButton ece = new JRadioButton("ECE");
            JRadioButton eee = new JRadioButton("EEE");
            JRadioButton mech = new JRadioButton("Mechanical");
            JRadioButton civil = new JRadioButton("Civil");

            departmentButtons = new JRadioButton[] {
                cse, ece, eee, mech, civil
            };

            ButtonGroup group = new ButtonGroup();
            JPanel departmentPanel =
                new JPanel(new GridLayout(0, 2, 4, 4));
            departmentPanel.setBackground(BG);

            for (JRadioButton button : departmentButtons) {
                button.setBackground(BG);
                group.add(button);
                departmentPanel.add(button);
            }

            addRow(form, "Department", departmentPanel);

            semesterBox = new JComboBox<>(new String[] {
                "Select Semester", "S1", "S2", "S3", "S4",
                "S5", "S6", "S7", "S8"
            });

            addRow(form, "Semester", semesterBox);

        } else {
            organizationField = new JTextField();
            addRow(form, "Organization Name", organizationField);
        }

        addRow(form, "Username", usernameField);
        addRow(form, "Password", passwordField);
        addRow(form, "Confirm Password", confirmField);

        JButton signup = createButton("Create Account");
        form.add(new JLabel(""));
        form.add(signup);

        signup.addActionListener(e -> createAccount());

        return new JScrollPane(form);
    }

    private void addRow(JPanel panel, String label, Component input) {
        panel.add(new JLabel(label));
        panel.add(input);
    }

    private String getDepartment() {
        if (departmentButtons == null) {
            return "";
        }

        for (JRadioButton button : departmentButtons) {
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }

    private void createAccount() {
        try {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());
            String confirm = new String(confirmField.getPassword());

            String department = "";
            String semester = "";
            String organization = "";

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()
                    || username.isEmpty() || password.isEmpty()
                    || confirm.isEmpty()) {
                throw new IllegalArgumentException(
                    "Please fill in all required fields."
                );
            }

            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                throw new IllegalArgumentException(
                    "Enter a valid email address."
                );
            }

            if (!phone.matches("[0-9]{10}")) {
                throw new IllegalArgumentException(
                    "Enter a valid 10-digit phone number."
                );
            }

            if (!password.equals(confirm)) {
                throw new IllegalArgumentException(
                    "Passwords do not match."
                );
            }

            if (password.length() < 4) {
                throw new IllegalArgumentException(
                    "Password must contain at least 4 characters."
                );
            }

            if (role.equals("Student")) {
                department = getDepartment();

                if (department.isEmpty()) {
                    throw new IllegalArgumentException(
                        "Please select a department."
                    );
                }

                if (semesterBox.getSelectedIndex() == 0) {
                    throw new IllegalArgumentException(
                        "Please select a semester."
                    );
                }

                semester = (String) semesterBox.getSelectedItem();

            } else {
                organization = organizationField.getText().trim();

                if (organization.isEmpty()) {
                    throw new IllegalArgumentException(
                        "Enter your organization name."
                    );
                }
            }

            String key = AppData.accountKey(role, username);

            if (AppData.ACCOUNTS.containsKey(key)) {
                throw new IllegalArgumentException(
                    "This username already exists for this role."
                );
            }

            Account account = new Account(
                name, email, phone, department, semester,
                organization, username, password, role
            );

            AppData.ACCOUNTS.put(key, account);

            showMessage("Account created! Please login.");

            passwordField.setText("");
            confirmField.setText("");

        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
        } catch (Exception ex) {
            showError("Signup failed. Please try again.");
        }
    }

    private void loginAccount() {
        try {
            String username = loginUsername.getText().trim();
            String password = new String(loginPassword.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException(
                    "Enter username and password."
                );
            }

            String key = AppData.accountKey(role, username);
            Account account = AppData.ACCOUNTS.get(key);

            if (account == null ||
                    !account.getPassword().equals(password)) {
                throw new IllegalArgumentException(
                    "Incorrect username or password."
                );
            }

            AppData.currentAccount = account;
            new DashboardFrame(role).setVisible(true);
            dispose();

        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
        } catch (Exception ex) {
            showError("Login failed. Please try again.");
        }
    }
}
