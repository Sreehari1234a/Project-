
public class Registration {
    private final String username;
    private final String eventName;

    public Registration(String username, String eventName) {
        this.username = username;
        this.eventName = eventName;
    }

    public String getUsername() { return username; }
    public String getEventName() { return eventName; }
}
