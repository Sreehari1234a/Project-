
import javax.swing.*;
import java.awt.*;

public class EventsFrame extends BaseFrame {
    private final boolean organizer;

    public EventsFrame(boolean organizer) {
        super("CampusConnect - Events");
        this.organizer = organizer;

        JPanel page = createPage("Events", "Select an event");

        DefaultListModel<Event> model = new DefaultListModel<>();
        for (Event event : AppData.EVENTS) {
            model.addElement(event);
        }

        JList<Event> list = new JList<>(model);
        list.setFont(new Font("Arial", Font.PLAIN, 16));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        page.add(new JScrollPane(list), BorderLayout.CENTER);

        JPanel buttons = new JPanel(new GridLayout(1, 2, 10, 10));
        buttons.setOpaque(false);

        JButton details = createButton("View Details");
        JButton back = createButton("Back to Dashboard");

        details.addActionListener(e -> {
            Event event = list.getSelectedValue();

            if (event == null) {
                showError("Please select an event.");
                return;
            }

            String message =
                "Event: " + event.getName() +
                "\nDate: " + event.getDate() +
                "\nVenue: " + event.getVenue() +
                "\nDescription: " + event.getDescription();

            if (!organizer) {
                int answer = JOptionPane.showConfirmDialog(
                    this, message + "\n\nRegister for this event?",
                    "Event Details", JOptionPane.YES_NO_OPTION
                );

                if (answer == JOptionPane.YES_OPTION) {
                    register(event);
                }
            } else {
                showMessage(message);
            }
        });

        back.addActionListener(e -> {
            new DashboardFrame(organizer ? "Organizer" : "Student")
                .setVisible(true);
            dispose();
        });

        buttons.add(details);
        buttons.add(back);

        page.add(buttons, BorderLayout.SOUTH);
        setContentPane(page);
    }

    private void register(Event event) {
        try {
            String username = AppData.currentAccount.getUsername();

            for (Registration r : AppData.REGISTRATIONS) {
                if (r.getUsername().equalsIgnoreCase(username)
                        && r.getEventName().equals(event.getName())) {
                    throw new IllegalArgumentException(
                        "You are already registered for this event."
                    );
                }
            }

            AppData.REGISTRATIONS.add(
                new Registration(username, event.getName())
            );

            showMessage("Registration successful!");

        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
        } catch (Exception ex) {
            showError("Registration failed.");
        }
    }
}
