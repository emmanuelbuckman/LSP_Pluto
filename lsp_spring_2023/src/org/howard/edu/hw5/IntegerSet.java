package org.howard.edu.hw5;

import java.util.ArrayList;
import java.util.List;
import org.howard.edu.hw5.IntegerSetException;

/**
 * 
 * @author emmanuelbuckman
 * IntegerSet class
 */

public class IntegerSet {
	
	private List<Integer> set = new ArrayList<Integer>();
	
	
	/**
	 * Default Constructor
	 */
	public IntegerSet(){
		
		set = new ArrayList<Integer>();	
//		System.out.println("new IntegerSet object created");
	}
	
	
	
	/**
	 * Clears the items in the set
	 */
	public void clear() {
		set.clear();
//		System.out.println("Set cleared! The length of the set is now " + set.size());
	}
	
	

	/**
	 * Method to get the length of the set
	 * 
	 * @returns the length of the set
	 */
	public int length() {
		return set.size();
	}
	
	
	
	/**
	 * Method to check if 2 sets are equal
	 * 
	 * @param b - the set to check for equality
	 * @return returns true if 2 sets are equal, false otherwise
	 */
	public boolean equals(IntegerSet b) {
		if( set.size() != b.length()) {
			return false;
		}
		for(int i: set) {
			 if (!b.contains(i)) {
				 return false;
			 }
				
			}
		return true;
		}
	
	
	
	/**
	 * Method to check if a set contains a certain item
	 * @param value - the item we are looking for within the set
	 * @return returns true if the value is in the set and false if not
	 */
	public boolean contains(int value) {
		if(set.contains(value)) {
			return true;
			}
		return false;
	}
	
	
	
	/**
	 * Method to get the largest element in the set
	 *
	 * @throws IntegerSetException if the set is empty.
	 * @return returns the largest number in the set
	 */
	public int largest() throws IntegerSetException{
			if (set.size() == 0) {
				throw new IntegerSetException("The set is empty");
			}
			int large = 0;
			for (int i : set) {
				if (i>large) {
					large = i;
				}
			}
			return large;	
		}
	
	
	
	/**
	 * Method to get the smallest value in the set
	 * 
	 * @throws IntegerSetException if the set is empty
	 * @return returns the smallest value in the set
	 */
	public int smallest() throws IntegerSetException{
		if (set.size() == 0) {
			throw new IntegerSetException("The set is empty");
		}
		int small = 999999999;
		for (int i : set) {
			if (i<small) {
				small = i;
			}
		} 
		return small;
	}
	
	
	/**
	 * Method to add an item to a set
	 * @param item - item to be added to the set
	 */
	public void add(int item) {
		if (!set.contains(item)) {
			set.add(item);
		}
	}
	
	
	/**
	 * Method to remove an item from a set. does nothing if the item in not
	 *  already in the set
	 * @param item - item to be removed from set
	 */
	public void remove(int item) {
		if (set.contains(item)) {
			set.remove(item);
		}
	}
	
	
	//Helper function which returns the item at a specific index
	public int get(Integer index) {
		return set.get(index);
	}
	
	
	
	/**
	 * Method to combine two sets together
	 * @param intSetb - set to combine with
	 */
	public void union(IntegerSet intSetb) {
		for (int i=0; i<intSetb.length(); i++) {
			if (!set.contains(intSetb.get(i))) {
				set.add(intSetb.get(i));
			}
		}
//		System.out.println(set.toString());
	}
	
	
	
	/**
	 * Method to find the intersection between two sets
	 * @param intSetb - set to look for intersection in
	 */
	public void intersect(IntegerSet intSetb) {
		for (int i =0; i<set.size(); i++) {
			int j = set.get(i);
			if (!intSetb.contains(j)) {
				set.remove(i);
			}
		}
//		System.out.println(set.toString());
	}
	
	
	
	/**
	 * Method to find the difference between two sets
	 * @param intSetb - set to find the difference with
	 */
	public void diff(IntegerSet intSetb) {
		for (int i =0; i<set.size(); i++) {
			int j = set.get(i);
			if (intSetb.contains(j)) {
				set.remove(i);
			}
		}
//		System.out.println(set.toString());
	}
	
	
	
	
	/**
	 * method to check if the set is empty
	 * @return returns true if the set is empty, false if otherwise
	 */
	boolean isEmpty() {
		if (set.size() > 0) {
//			System.out.println("The set is not empty");
			return false;
		}
//		System.out.println("The set is empty");
		return true;
	}
	
	
	
	/**
	 * Method to return a string representation of elements in set
	 * @return Returns a string representation of set 
	 */
	public String toString() {
		String setStr = "";
		setStr = setStr + "[";
		
		for (int i=0; i<set.size(); i++) {
			setStr = setStr + Integer.toString(set.get(i));
			setStr = setStr + ",";
		}
		
		if (setStr.length() > 1 && setStr.endsWith(",")) {
			setStr = setStr.substring(0, setStr.length() - 1);
		}
		
		setStr = setStr + "]";
		
		return setStr;
		
	}
	
	

}


