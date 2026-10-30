
public class Event {
    private final String name;
    private final String date;
    private final String venue;
    private final String description;

    public Event(String name, String date, String venue,
                 String description) {
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDate() { return date; }
    public String getVenue() { return venue; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return name + " | " + date;
    }
}
