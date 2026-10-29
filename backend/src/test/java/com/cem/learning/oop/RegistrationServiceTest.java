package com.cem.learning.oop;

import com.cem.learning.oop.exception.EventFullException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegistrationServiceTest {
    @Test
    void dashboardUsesOverriddenStudentLabel() {
        RegistrationService service = new RegistrationService();
        Student student = new Student("s1", "Test Student", "STU-001");
        assertEquals("Test Student — My campus events", service.dashboardFor(student));
    }

    @Test
    void fullEventThrowsCustomException() {
        RegistrationService service = new RegistrationService();
        Student student = new Student("s1", "Test Student", "STU-001");
        assertThrows(EventFullException.class, () -> service.register(student, "event-1", 0));
    }
}
