/*
 * Hasan Aytug
 * 10/12/2025
 * CS320 - Project One
 * */

package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modules.Appointment;
import modules.AppointmentService;

import java.util.Date;

class AppointmentServiceTest {

    private AppointmentService appointmentService;
    private Date futureDate = new Date(System.currentTimeMillis() + 86400000); // Current datetime + 1 day

    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService();
    }

    // Create a valid appointment
    private Appointment createValidAppointment(String id) {
        return new Appointment(id, futureDate, "Description");
    }
    
    @Test
    void testAddAppointment() {
        Appointment appointment1 = createValidAppointment("123");
        appointmentService.addAppointment(appointment1);
        assertNotNull(appointmentService.getAppointment("123"));
        assertEquals(appointment1, appointmentService.getAppointment("123"));
    }

    @Test
    void testAddAppointmentWithDuplicateId() {
        Appointment appointment1 = createValidAppointment("1234");
        appointmentService.addAppointment(appointment1);
        Appointment appointment2 = createValidAppointment("1234"); // Try adding appointment with an existent id
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
    }

    @Test
    void testDeleteAppointment() {
        Appointment appointment1 = createValidAppointment("12345");
        appointmentService.addAppointment(appointment1);
        assertNotNull(appointmentService.getAppointment("12345"));
        appointmentService.deleteAppointment("12345"); // Delete appointment by id
        assertNull(appointmentService.getAppointment("12345"));
    }

    @Test
    void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("0000000000"); // Try deleting appointment by non-existent id
        });
    }
}
