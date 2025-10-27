/*
 * Hasan Aytug
 * 10/12/2025
 * CS320 - Project One
 * */

package modules;
import java.util.Date;

public class Appointment {

    private final String appointmentId; // AppointmentID is final, not updatable
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentId, Date appointmentDate, String description) {
        // Validations
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("ID can't be empty or longer than 10 characters!");
        }

        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Date can't be empty or past date!");
        }

        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description can't be empty or longer than 50 characters!");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Date can't be empty or past date!");
        }
        this.appointmentDate = appointmentDate;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description can't be empty or longer than 50 characters!");
        }
        this.description = description;
    }
}
