package org.howard.edu.lsp.assignment5;


/**
 * Test driver for IntegerSet class.
 */


public class Driver {
	
	/**
	 * Ivan Ibhawoh
	 * @param args
	 */
    public static void main(String[] args) {
        // Test basic operations
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Length of Set1 is: " + set1.length());
        System.out.println("Set1 contains 2: " + set1.contains(2));
        System.out.println("Smallest value in Set1 is: " + set1.smallest());
        System.out.println("Largest value in Set1 is: " + set1.largest());

        // Test set operations
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("\nTesting set operations:");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set2 is: " + set2.toString());

        // Test union
        IntegerSet unionSet = new IntegerSet();
        unionSet.add(1);
        unionSet.add(2);
        unionSet.add(3);  // Copy of set1
        System.out.println("Before union, unionSet is: " + unionSet.toString());
        unionSet.union(set2);
        System.out.println("Result of union of Set1 and Set2: " + unionSet.toString());

        // Test intersection
        IntegerSet intersectSet = new IntegerSet();
        intersectSet.add(1);
        intersectSet.add(2);
        intersectSet.add(3);  // Copy of set1
        System.out.println("\nBefore intersect, intersectSet is: " + intersectSet.toString());
        intersectSet.intersect(set2);
        System.out.println("Result of intersection of Set1 and Set2: " + intersectSet.toString());

        // Test difference
        IntegerSet diffSet = new IntegerSet();
        diffSet.add(1);
        diffSet.add(2);
        diffSet.add(3);  // Copy of set1
        System.out.println("\nBefore diff, diffSet is: " + diffSet.toString());
        diffSet.diff(set2);
        System.out.println("Result of difference (Set1 - Set2): " + diffSet.toString());

        // Test complement
        IntegerSet compSet = new IntegerSet();
        compSet.add(1);
        compSet.add(2);
        compSet.add(3);  // Copy of set1
        System.out.println("\nBefore complement, compSet is: " + compSet.toString());
        compSet.complement(set2);  // Assuming set2 as universal set for this test
        System.out.println("Result of complement of Set1 with Set2: " + compSet.toString());

        // Test equals
        IntegerSet set3 = new IntegerSet();
        set3.add(3);
        set3.add(2);
        set3.add(1);  // Same elements as set1, different order
        System.out.println("\nSet1 equals Set3 (same elements, different order): " + set1.equals(set3));

        // Test remove
        IntegerSet removeSet = new IntegerSet();
        removeSet.add(1);
        removeSet.add(2);
        System.out.println("\nBefore remove, removeSet is: " + removeSet.toString());
        removeSet.remove(1);
        System.out.println("After removing 1, removeSet is: " + removeSet.toString());

        // Test clear and isEmpty
        IntegerSet emptySet = new IntegerSet();
        System.out.println("\nEmpty set is empty: " + emptySet.isEmpty());
        emptySet.add(1);
        System.out.println("After adding 1, is empty: " + emptySet.isEmpty());
        emptySet.clear();
        System.out.println("After clear, is empty: " + emptySet.isEmpty());
    }
}