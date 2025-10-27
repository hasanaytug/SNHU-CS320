/*
 * Hasan Aytug
 * 10/12/2025
 * CS320 - Project One
 * */

package modules;

public class Task {

    private final String taskId;
    private String name;
    private String description;

    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID. Must be non-null and no longer than 10 characters.");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name. Must be non-null and no longer than 20 characters.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description. Must be non-null and no longer than 50 characters.");
        }
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name. Must be non-null and no longer than 20 characters.");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description. Must be non-null and no longer than 50 characters.");
        }
        this.description = description;
    }
}
