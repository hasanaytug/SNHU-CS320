/*
 * Hasan Aytug
 * 10/12/2025
 * CS320 - Project One
 * */

package test;
import modules.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testTaskCreationValid() {
        Task task = new Task("12345", "Task Name", "Task Description");
        assertNotNull(task);
        assertEquals("12345", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    void testTaskCreationInvalidIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Name", "Description");
        });
    }

    @Test
    void testTaskCreationInvalidIdLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Name", "Description");
        });
    }

    @Test
    void testTaskCreationInvalidNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", null, "Description");
        });
    }

    @Test
    void testTaskCreationInvalidNameLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "This is a very long task name", "Description");
        });
    }

    @Test
    void testTaskCreationInvalidDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Name", null);
        });
    }

    @Test
    void testTaskCreationInvalidDescriptionLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Name", "This is a very, very, very, very, very, very, very, very long description that should fail.");
        });
    }

    @Test
    void testSetNameValid() {
        Task task = new Task("123", "Old Name", "Description");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    @Test
    void testSetNameInvalid() {
        Task task = new Task("123", "Old Name", "Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("This is a very long task name that should fail");
        });
    }

    @Test
    void testSetDescriptionValid() {
        Task task = new Task("123", "Name", "Old Description");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }

    @Test
    void testSetDescriptionInvalid() {
        Task task = new Task("123", "Name", "Old Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("This is a very, very, very, very, very, very, very, very long description that should fail.");
        });
    }
}