 // Frame 1 - Login
    static void loginFrame() {

        JFrame frame = new JFrame("CampusConnect - Login");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel title = new JLabel("CampusConnect Login", SwingConstants.CENTER);
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();

        JButton loginButton = new JButton("Login");

        frame.add(title);
        frame.add(new JLabel());

        frame.add(userLabel);
        frame.add(username);

        frame.add(passLabel);
        frame.add(password);

        frame.add(new JLabel());
        frame.add(loginButton);

      

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
