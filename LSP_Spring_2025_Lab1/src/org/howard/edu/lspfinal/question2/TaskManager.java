package org.howard.edu.lspfinal.question2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of tasks, supporting addition, retrieval,
 * status updates, and printing tasks grouped by status.
 */
public class TaskManager {
    private Map<String, Task> tasks;

    /**
     * Constructs a new TaskManager.
     */
    public TaskManager() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a new task with the specified name, priority, and status.
     * 
     * @param name     the unique name of the task
     * @param priority the priority (lower number = higher priority)
     * @param status   the status ("TODO", "IN_PROGRESS", "DONE")
     * @throws DuplicateTaskException if a task with the same name exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its name.
     * 
     * @param name the name of the task
     * @return the task
     * @throws TaskNotFoundException if the task does not exist
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task task = tasks.get(name);
        if (task == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return task;
    }

    /**
     * Updates the status of an existing task.
     * 
     * @param name   the name of the task
     * @param status the new status ("TODO", "IN_PROGRESS", "DONE")
     * @throws TaskNotFoundException if the task does not exist
     */
    public void updateStatus(String name, String status) throws TaskNotFoundException {
        Task task = tasks.get(name);
        if (task == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        task.setStatus(status);
    }

    /**
     * Prints all tasks grouped by status.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        String[] statuses = {"TODO", "IN_PROGRESS", "DONE"};
        for (String status : statuses) {
            System.out.println(status + ":");
            List<Task> tasksWithStatus = new ArrayList<>();
            for (Task task : tasks.values()) {
                if (task.getStatus().equals(status)) {
                    tasksWithStatus.add(task);
                }
            }
            for (Task task : tasksWithStatus) {
                System.out.println("  " + task);
            }
        }
    }
}