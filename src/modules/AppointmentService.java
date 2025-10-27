/*
 * Hasan Aytug
 * 10/12/2025
 * CS320 - Project One
 * */

package modules;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    private final Map<String, Appointment> appointments = new HashMap<>();

    // Add a new appointment
    public void addAppointment(Appointment appointment) {
        if (appointment == null || appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Invalid appointment or ID already exists!");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Delete an appointment by ID
    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null || !appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Invalid appointment ID or ID does not exist!");
        }
        appointments.remove(appointmentId);
    }

    // Get an appointment by ID
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
