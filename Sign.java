import javax.swing.*;
import java.awt.*;

public class Sign {

    public static void main(String[] args) {

        JFrame frame = new JFrame("CampusConnect - Student");

        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JLabel title = new JLabel(
                "Student Details",
                SwingConstants.CENTER
        );

        JLabel nameLabel = new JLabel("Name:");
        JLabel rollLabel = new JLabel("Roll No:");
        JLabel departmentLabel = new JLabel("Department:");
        JLabel semesterLabel = new JLabel("Semester:");
        JLabel collegeLabel = new JLabel("College:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel phoneLabel = new JLabel("Phone:");

        JTextField nameField = new JTextField();
        JTextField rollField = new JTextField();
        JRadiobutton dep1 = new JRadiobutton("CSE");
        JRadiobutton dep2 = new JRadiobutton("EEE");
        JRadiobutton dep3 = new JRadiobutton("ECE");
        JRadiobutton dep4 = new JRadiobutton("MECH");
        JRadiobutton s1= new JRadiobutton("S1");
        ButtonGroup group = new ButtonGroup();
        group.add(dep1);
        group.add(dep2);
        group.add(dep3);
        group.add(dep4);
        JRadiobutton s1= new JRadiobutton("S1");
        JRadiobutton s2= new JRadiobutton("S2");
        JRadiobutton s3= new JRadiobutton("S3");
        JRadiobutton s4= new JRadiobutton("S4");
        JRadiobutton s5= new JRadiobutton("S5");
        JRadiobutton s6= new JRadiobutton("S6");
        JRadiobutton s7= new JRadiobutton("S7");
        JRadiobutton s8= new JRadiobutton("S8");
        JTextField collegeField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();

        JButton saveButton = new JButton("Save");

        frame.add(title);
        frame.add(new JLabel());

        frame.add(nameLabel);
        frame.add(nameField);

        frame.add(rollLabel);
        frame.add(rollField);

        frame.add(departmentLabel);
        frame.add(dep1);
        frame.add(dep2);
        frame.add(dep3);
        frame.add(dep4);
        
        frame.add(semesterLabel);
        frame.add(s1);
        frame.add(s2);
        frame.add(s3);
        frame.add(s4);
        frame.add(s5);
        frame.add(s6);
        frame.add(s7);
        frame.add(s8);

        frame.add(collegeLabel);
        frame.add(collegeField);

        frame.add(emailLabel);
        frame.add(emailField);

        frame.add(phoneLabel);
        frame.add(phoneField);

        frame.add(new JLabel());
        frame.add(saveButton);

        saveButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Student Details Saved!"
            );

        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
