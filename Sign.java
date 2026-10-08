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
        JRadioButton dep1 = new JRadiobutton("CSE");
        JRadioButton dep2 = new JRadiobutton("EEE");
        JRadioButton dep3 = new JRadiobutton("ECE");
        JRadioButton dep4 = new JRadiobutton("MECH");
        JRadioButton s1= new JRadiobutton("S1");
        ButtonGroup group = new ButtonGroup();
        group.add(dep1);
        group.add(dep2);
        group.add(dep3);
        group.add(dep4);
        JRadioButton s1= new JRadiobutton("S1");
        JRadioButton s2= new JRadiobutton("S2");
        JRadioButton s3= new JRadiobutton("S3");
        JRadioButton s4= new JRadiobutton("S4");
        JRadioButton s5= new JRadiobutton("S5");
        JRadioButton s6= new JRadiobutton("S6");
        JRadioButton s7= new JRadiobutton("S7");
        JRadioButton s8= new JRadiobutton("S8");
        ButtonGroup grp = new ButtonGroup();
        grp.add(s1);
        grp.add(s2);
        grp.add(s3);
        grp.add(s4);
        grp.add(s5);
        grp.add(s6);
        grp.add(s7);
        grp.add(s8);
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
