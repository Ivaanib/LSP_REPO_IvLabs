package org.howard.edu.lsp.assignment6;

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

    /** Clears the internal representation of the set. */
    public void clear() {
        set.clear();
    }

    /** Returns the length of the set.
     * @return the number of elements in the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true if the 2 sets are equal, false otherwise;
     * Two sets are equal if they contain all of the same values in ANY order.
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

    /** Returns true if the set contains the value, otherwise false.
     * @param value the integer to check
     * @return true if value exists in set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /** Returns the largest item in the set.
     * @return the largest integer in the set
     * @throws IntegerSetException if the set is empty
     */
    public int largest() throws IntegerSetException {
        if (isEmpty()) throw new IntegerSetException("Set is empty");
        return set.stream().max(Integer::compareTo).orElseThrow();
    }

    /** Returns the smallest item in the set.
     * @return the smallest integer in the set
     * @throws IntegerSetException if the set is empty
     */
    public int smallest() throws IntegerSetException {
        if (isEmpty()) throw new IntegerSetException("Set is empty");
        return set.stream().min(Integer::compareTo).orElseThrow();
    }

    /** Adds an item to the set or does nothing it already there.
     * @param item the integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) set.add(item);
    }

    /** Removes an item from the set or does nothing if not there.
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /** Set union.
     * @param intSetb the set to union with
     */
    public void union(IntegerSet intSetb) {
        for (int num : intSetb.set) {
            if (!set.contains(num)) set.add(num);
        }
    }

    /** Set intersection.
     * @param intSetb the set to intersect with
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /** Set difference, i.e., s1 – s2.
     * @param intSetb the set to subtract
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /** Set complement, all elements not in s1.
     * @param intSetb the universal set to complement against
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> complementSet = new ArrayList<>(intSetb.set);
        complementSet.removeAll(this.set);
        this.set = complementSet;
    }

    /** Returns true if the set is empty, false otherwise.
     * @return true if the set is empty
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /** Return String representation of your set.
     * @return string representation of the set
     */
    @Override
    public String toString() {
        return set.toString();
    }
}