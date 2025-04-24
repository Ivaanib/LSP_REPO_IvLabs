package org.howard.edu.lspfinal.question3;

/**
 * Abstract base class for generating reports using the Template Method pattern.
 */
public abstract class ReportGenerator {
    /**
     * Template method defining the report generation workflow.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    /**
     * Loads the data for the report.
     * To be implemented by subclasses.
     */
    protected abstract void loadData();

    /**
     * Formats the loaded data.
     * To be implemented by subclasses.
     */
    protected abstract void formatData();

    /**
     * Prints the final report.
     * To be implemented by subclasses.
     */
    protected abstract void printReport();
}