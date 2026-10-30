
import javax.swing.*;
import java.awt.*;

public class CreateEventFrame extends BaseFrame {

    public CreateEventFrame() {
        super("CampusConnect - Create Event");

        JPanel page = createPage(
            "Create New Event", "Enter event details"
        );

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));
        form.setBackground(BG);

        JTextField name = new JTextField();
        JTextField date = new JTextField();
        JTextField venue = new JTextField();
        JTextField description = new JTextField();

        form.add(new JLabel("Event Name"));
        form.add(name);
        form.add(new JLabel("Date"));
        form.add(date);
        form.add(new JLabel("Venue"));
        form.add(venue);
        form.add(new JLabel("Description"));
        form.add(description);

        JButton save = createButton("Save Event");
        JButton back = createButton("Back");

        save.addActionListener(e -> {
            try {
                String n = name.getText().trim();
                String d = date.getText().trim();
                String v = venue.getText().trim();
                String desc = description.getText().trim();

                if (n.isEmpty() || d.isEmpty()
                        || v.isEmpty() || desc.isEmpty()) {
                    throw new IllegalArgumentException(
                        "Please fill in all event details."
                    );
                }

                AppData.EVENTS.add(new Event(n, d, v, desc));

                showMessage("Event created successfully!");
                new DashboardFrame("Organizer").setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                showError(ex.getMessage());
            } catch (Exception ex) {
                showError("Could not create event.");
            }
        });

        back.addActionListener(e -> {
            new DashboardFrame("Organizer").setVisible(true);
            dispose();
        });

        form.add(save);
        form.add(back);

        page.add(form, BorderLayout.CENTER);
        setContentPane(page);
    }
}
