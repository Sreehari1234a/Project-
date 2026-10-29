package com.cem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String title;

    @Column(nullable = false, length = 80)
    private String category;

    @Column(nullable = false, length = 160)
    private String venue;

    @Column(nullable = false)
    private LocalDateTime startsAt;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private int registeredCount = 0;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false, length = 24)
    private String status = "PENDING_APPROVAL";

    @Column(length=120) private String organizerName;
    @Column(length=180) private String organizerEmail;

    protected Event() {}

    public Event(String title, String category, String venue, LocalDateTime startsAt,
                 int capacity, String description) {
        this.title = title;
        this.category = category;
        this.venue = venue;
        this.startsAt = startsAt;
        this.capacity = capacity;
        this.description = description;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getVenue() { return venue; }
    public LocalDateTime getStartsAt() { return startsAt; }
    public int getCapacity() { return capacity; }
    public int getRegisteredCount() { return registeredCount; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public String getOrganizerName() { return organizerName; }
    public String getOrganizerEmail() { return organizerEmail; }

    public void setTitle(String title) { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setVenue(String venue) { this.venue = venue; }
    public void setStartsAt(LocalDateTime startsAt) { this.startsAt = startsAt; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setRegisteredCount(int registeredCount) { this.registeredCount = registeredCount; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status) { this.status = status; }
    public void setOrganizerName(String organizerName) { this.organizerName = organizerName; }
    public void setOrganizerEmail(String organizerEmail) { this.organizerEmail = organizerEmail; }
}
