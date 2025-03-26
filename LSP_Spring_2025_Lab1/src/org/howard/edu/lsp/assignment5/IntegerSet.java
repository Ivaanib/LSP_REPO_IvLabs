package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements a set of integers using an ArrayList.
 */
public class IntegerSet {
	/**
	 * Ivan Ibhawoh
	 * @param args
	 */
    private List<Integer> set = new ArrayList<Integer>();

    /** Default constructor that initializes an empty set. */
    public IntegerSet() {}

    /**
     * Constructor that initializes set with an existing ArrayList.
     * @param set ArrayList of integers to initialize the set
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = new ArrayList<>(set);
    }

    /** Removes all elements from the set. */
    public void clear() {
        set.clear();
    }

    /** Returns the number of elements in the set.
     * @return the number of elements in the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if this set equals another object.
     * @param o the object to compare with
     * @return true if sets are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof IntegerSet) {
            IntegerSet other = (IntegerSet) o;
            return set.containsAll(other.set) && other.set.containsAll(set);
        }
        return false;
    }

    /** Checks if the set contains a specific value.
     * @param value the integer to check
     * @return true if value exists in set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /** Returns the largest value in the set.
     * @return the largest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (isEmpty()) throw new IllegalStateException("Set is empty");
        return set.stream().max(Integer::compareTo).orElseThrow();
    }

    /** Returns the smallest value in the set.
     * @return the smallest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) throw new IllegalStateException("Set is empty");
        return set.stream().min(Integer::compareTo).orElseThrow();
    }

    /** Adds an item to the set if not already present.
     * @param item the integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) set.add(item);
    }

    /** Removes an item from the set if it exists.
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /** Combines this set with another set, adding all elements from intSetb.
     * @param intSetb the set to union with
     */
    public void union(IntegerSet intSetb) {
        for (int num : intSetb.set) {
            if (!set.contains(num)) set.add(num);
        }
    }

    /** Keeps only elements present in both this set and another set.
     * @param intSetb the set to intersect with
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /** Removes all elements present in another set from this set.
     * @param intSetb the set to subtract
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /** Updates this set to contain elements from a universal set that are not in this set.
     * @param universalSet the universal set to complement against
     */
    public void complement(IntegerSet universalSet) {
        List<Integer> complementSet = new ArrayList<>(universalSet.set);
        complementSet.removeAll(this.set);
        this.set = complementSet;
    }

    /** Checks if the set is empty.
     * @return true if the set is empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /** @return string representation of the set */
    @Override
    public String toString() {
        return set.toString();
    }
}