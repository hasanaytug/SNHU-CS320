/*
 * Hasan Aytug
 * 10/12/2025
 * CS320 - Project One
 * */

package test;
import org.junit.jupiter.api.Test;

import modules.Appointment;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

class AppointmentTest {

    // Create a valid future date
    private Date futureDate = new Date(System.currentTimeMillis() + 86400000); // Current datetime + 1 day

    @Test
    void testAppointmentCreationWithValidData() {
        Appointment appointment = new Appointment("12345", futureDate, "Description");
        assertNotNull(appointment);
        assertEquals("12345", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Description", appointment.getDescription());
    }

    @Test
    void testAppointmentIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Description");
        });
    }

    @Test
    void testAppointmentIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Description");
        });
    }

    @Test
    void testAppointmentDateInPast() {
        Date pastDate = new Date();
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", pastDate, "Description");
        });
    }

    @Test
    void testAppointmentDateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Description");
        });
    }

    @Test
    void testDescriptionTooLong() {
        String longDescription = "askldfjasl;kjfdl;asj dfal;kjsdfl jasldfj lasjdfasljdflasjdfaslkkdjfaowufjasjdf asdf iasdfoiausiod fusaidfj asldf";
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, longDescription);
        });
    }

    @Test
    void testDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, null);
        });
    }

    @Test
    void testSetters() {
        Appointment appointment = new Appointment("12345", futureDate, "Some description about the appointment");

        // Test updating date
        Date newFutureDate = new Date(System.currentTimeMillis() + 86400000); // Add one day
        appointment.setAppointmentDate(newFutureDate);
        assertEquals(newFutureDate, appointment.getAppointmentDate());

        // Test updating description
        appointment.setDescription("Description is updated");
        assertEquals("Description is updated", appointment.getDescription());

        // Test invalid updates
        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(new Date(System.currentTimeMillis() - 86400000))); // Past date test
        assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(null));
    }
}