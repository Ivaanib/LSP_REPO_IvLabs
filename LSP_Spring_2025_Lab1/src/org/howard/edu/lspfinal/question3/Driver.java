package org.howard.edu.lspfinal.question3;

/**
 * Driver class to demonstrate the report generation system.
 */
public class Driver {
    public static void main(String[] args) {
        ReportGenerator salesReport = new SalesReport();
        ReportGenerator inventoryReport = new InventoryReport();

        salesReport.generateReport();
        inventoryReport.generateReport();
    }
}