package org.howard.edu.lspfinal.question2;

/**
 * Represents a task with a name, priority, and status.
 */
public class Task {
    private String name;
    private int priority;
    private String status;

    /**
     * Constructs a new Task.
     * 
     * @param name     the unique name of the task
     * @param priority the priority (lower number = higher priority)
     * @param status   the status ("TODO", "IN_PROGRESS", "DONE")
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    /**
     * Gets the task name.
     * 
     * @return the task name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the task priority.
     * 
     * @return the task priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Gets the task status.
     * 
     * @return the task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the task status.
     * 
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}