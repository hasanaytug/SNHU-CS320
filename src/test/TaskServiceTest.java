/*
 * Hasan Aytug
 * 10/12/2025
 * CS320 - Project One
 * */

package test;
import modules.Task;
import modules.TaskService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("T1", "Task One", "Description One");
        service.addTask(task);
        assertNotNull(service.getTask("T1"));
        assertEquals("Task One", service.getTask("T1").getName());
    }

    @Test
    void testAddTaskDuplicateIdThrowsException() {
        TaskService service = new TaskService();
        Task task1 = new Task("T1", "Task One", "Description One");
        service.addTask(task1);
        Task task2 = new Task("T1", "Task Two", "Description Two");
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
    }

    @Test
    void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("T2", "Task Two", "Description Two");
        service.addTask(task);
        assertNotNull(service.getTask("T2"));
        service.deleteTask("T2");
        assertNull(service.getTask("T2"));
    }

    @Test
    void testDeleteTaskNotFoundThrowsException() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("non-existent-id");
        });
    }

    @Test
    void testUpdateName() {
        TaskService service = new TaskService();
        Task task = new Task("T3", "Old Name", "Description");
        service.addTask(task);
        service.updateName("T3", "New Name");
        assertEquals("New Name", service.getTask("T3").getName());
    }

    @Test
    void testUpdateNameNotFoundThrowsException() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateName("non-existent-id", "New Name");
        });
    }

    @Test
    void testUpdateDescription() {
        TaskService service = new TaskService();
        Task task = new Task("T4", "Name", "Old Description");
        service.addTask(task);
        service.updateDescription("T4", "New Description");
        assertEquals("New Description", service.getTask("T4").getDescription());
    }

    @Test
    void testUpdateDescriptionNotFoundThrowsException() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateDescription("non-existent-id", "New Description");
        });
    }
}