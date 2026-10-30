
import java.util.*;

public class AppData {
    public static final Map<String, Account> ACCOUNTS = new HashMap<>();
    public static final List<Event> EVENTS = new ArrayList<>();
    public static final List<Registration> REGISTRATIONS =
        new ArrayList<>();

    public static Account currentAccount;

    public static String accountKey(String role, String username) {
        return role.toLowerCase() + "|" + username.trim().toLowerCase();
    }

    static {
        EVENTS.add(new Event(
            "Tech Fest 2026", "15-11-2026",
            "College Auditorium", "Technical events and activities"
        ));

        EVENTS.add(new Event(
            "Coding Challenge", "20-11-2026",
            "Computer Lab", "Programming competition"
        ));

        EVENTS.add(new Event(
            "Project Expo", "25-11-2026",
            "Seminar Hall", "Student project exhibition"
        ));
    }
}
