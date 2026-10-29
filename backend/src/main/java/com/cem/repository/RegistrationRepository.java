package com.cem.repository;
import com.cem.model.EventRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface RegistrationRepository extends JpaRepository<EventRegistration,Long> {
 Optional<EventRegistration> findByEventIdAndEmailIgnoreCase(Long eventId,String email);
 boolean existsByEventIdAndEmailAndStatus(Long eventId, String email, String status);
 List<EventRegistration> findByEmailIgnoreCaseOrderByRegisteredAtDesc(String email);
 List<EventRegistration> findByEventIdOrderByRegisteredAtAsc(Long eventId);
 long countByEventIdAndStatus(Long eventId, String status);
}
