package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when attempting to add a task with a duplicate name.
 */
public class DuplicateTaskException extends Exception {
    /**
     * Constructs a new DuplicateTaskException.
     * 
     * @param message the error message
     */
    public DuplicateTaskException(String message) {
        super(message);
    }
}