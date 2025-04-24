package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when a task is not found.
 */
public class TaskNotFoundException extends Exception {
    /**
     * Constructs a new TaskNotFoundException.
     * 
     * @param message the error message
     */
    public TaskNotFoundException(String message) {
        super(message);
    }
}