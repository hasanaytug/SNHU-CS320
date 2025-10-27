/*
 * Hasan Aytug
 * 10/12/2025
 * CS320 - Project One
 * */

package modules;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (task == null || tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task cannot be null or already exists.");
        }
        tasks.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        if (taskId == null || !tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID cannot be null or does not exist.");
        }
        tasks.remove(taskId);
    }

    public void updateName(String taskId, String newName) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found with ID: " + taskId);
        }
        task.setName(newName);
    }

    public void updateDescription(String taskId, String newDescription) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found with ID: " + taskId);
        }
        task.setDescription(newDescription);
    }

    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}