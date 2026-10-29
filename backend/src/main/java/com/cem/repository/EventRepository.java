package com.cem.repository;
import com.cem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface EventRepository extends JpaRepository<Event,Long> {
 List<Event> findByStatusOrderByStartsAtAsc(String status);
 List<Event> findAllByOrderByStartsAtAsc();
 List<Event> findByOrganizerEmailIgnoreCaseOrderByStartsAtAsc(String organizerEmail);
}
