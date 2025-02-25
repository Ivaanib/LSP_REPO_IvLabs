package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ETLPipeline {
    
	/**
	 * Ivan Ibhawoh
	 * @param args
	 */
    private static final String INPUT = "data/products.csv";
    private static final String OUTPUT = "data/transformed_products.csv";
    
    public static void main(String[] args) {
        try {
            String[][] rawData = extractData();
            System.out.println("DEBUG: Got " + rawData.length + " products to work with");
            String[][] processedData = transformData(rawData);
            System.out.println("DEBUG: Transformed everything, now writing...");
            loadData(processedData);
            System.out.println("File processed and saved!");
        } catch (IOException e) {
            System.out.println("Oops, check this out: " + e.getMessage());
            System.out.println("Make sure products.csv is in the data folder");
        }
         catch (NumberFormatException e) {
            System.out.println("Yikes, bad number in the file: " + e.getMessage());
        }
    }
    
    
    public static String[][] extractData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(INPUT));
        String line;
        int count = 0;
        
        // Line counter
        while ((line = reader.readLine()) != null) {
            count++;
        }
        reader.close();
        System.out.println("DEBUG: Total lines in file: " + count);
        
        String[][] products = new String[count - 1][4]; // -1 for header
        reader = new BufferedReader(new FileReader(INPUT));
        reader.readLine(); 
        
        int i = 0;
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) {  
                System.out.println("DEBUG: Skipping empty line");
                continue;
            }
            String[] bits = line.split(",");
            if (bits.length == 4 && bits[0] != null && bits[2] != null) {  // Update this
                products[i] = bits;
                i++;
            } else {
                System.out.println("DEBUG: Skipping this line: " + line);
            }
        }
        reader.close();
        if (i < products.length) {  // Add this block
            String[][] adjusted = new String[i][4];
            for (int j = 0; j < i; j++) {
                adjusted[j] = products[j];
            }
            products = adjusted;
        }
        return products;
    }
    
    
    public static String[][] transformData(String[][] input) {
        String[][] output = new String[input.length][5]; // 5th is for price range
        
        for (int i = 0; i < input.length; i++) {
            
            int id = Integer.parseInt(input[i][0]);
            String name = input[i][1].toUpperCase(); 
            double price = Double.parseDouble(input[i][2]);
            String category = input[i][3];
            String priceRange = ""; 
            
            
            if (category.equals("Electronics")) {
                price = price * 0.9; 
                price = Math.round(price * 100.0) / 100.0; // Keep it to 2 decimals
                System.out.println("DEBUG: Discounted " + name + " to " + price);
            }
            
            // Error check 
            if (price > 500 && category.equals("Electronics")) {
                category = "Premium Electronics";
                System.out.println("DEBUG: Upgraded " + name + " to Premium");
            } else if (category.equals("Electronics")) {
                category = "Electronics"; 
            }
            
            // Price range logic 
            if (price <= 10 && price >= 0) {
                priceRange = "Low";
            } else if (price > 10 && price <= 100) {
                priceRange = "Medium";
            } else if (price > 100 && price <= 500) {
                priceRange = "High";
            } else if (price > 500) {
                priceRange = "Premium";
            } else {
                System.out.println("DEBUG: There is an issue with price" );
                priceRange = "Unknown"; 
            }
            
            
            output[i][0] = String.valueOf(id);
            output[i][1] = name;
            output[i][2] = String.format("%.2f", price);
            output[i][3] = category;
            output[i][4] = priceRange;
        }
        return output;
    }
    // Load - dump it into the new file
    public static void loadData(String[][] data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT));
        
        // Header row
        String header = "ProductID,Name,Price,Category,PriceRange";
        writer.write(header + "\n");
        System.out.println("DEBUG: Wrote header");
        
        // Write all the products
        for (int i = 0; i < data.length; i++) {
            if (data[i].length == 5) { // Just making sure
                String line = data[i][0] + "," + 
                            data[i][1] + "," + 
                            data[i][2] + "," + 
                            data[i][3] + "," + 
                            data[i][4];
                writer.write(line + "\n");
            } else {
                System.out.println("DEBUG: Skipping bad row at index " + i);
            }
        }
        writer.close();
        System.out.println("DEBUG: File write complete!");
    }
}