
public class Account {
    private final String name;
    private final String email;
    private final String phone;
    private final String department;
    private final String semester;
    private final String organization;
    private final String username;
    private final String password;
    private final String role;

    public Account(String name, String email, String phone,
                   String department, String semester,
                   String organization, String username,
                   String password, String role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.semester = semester;
        this.organization = organization;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDepartment() { return department; }
    public String getSemester() { return semester; }
    public String getOrganization() { return organization; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}
