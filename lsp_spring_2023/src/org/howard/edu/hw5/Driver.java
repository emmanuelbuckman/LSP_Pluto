package org.howard.edu.hw5;

import org.howard.edu.hw5.IntegerSet;
import org.howard.edu.hw5.IntegerSetException;

public class Driver {

	public static void main(String[] args) {
		
		IntegerSet set1 = new IntegerSet();
		set1.isEmpty();
		
		//adding items to set 1
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		
		//Testing if the items were added
		System.out.println("The items have been added to the set. The value of set1 is now " + set1.toString());
		System.out.println("The length of set1 is " + set1.length());
		
		//Testing isEmpty() method
		set1.isEmpty();
		
		//Adding items to set2
		IntegerSet set2 = new IntegerSet();
		set2.add(3);
		set2.add(1);
		set2.add(2);
		
		System.out.println("The items have been added to the set. The value of set2 is now " + set2.toString());
		
		IntegerSet set3 = new IntegerSet();
		set3.add(4);
		set3.add(5);
		set3.add(2);
		set3.add(6);
		
		System.out.println("The items have been added to the set. The value of set3 is now " + set3.toString());
		
		//Testing the remove() method
		set3.remove(2);
		System.out.println("The number has been removed from set3. The value of set3 is now " + set3.toString());
		
		//Testing the equals() method with equal sets
		if (set1.equals(set2)) {
			System.out.println("set1 and set2 are equal");
		}else {System.out.println("set1 and set2 are not equal");}
		
		
		//testing the equals() method with unequal sets
		if (set1.equals(set3)) {
			System.out.println("set1 and set3 are equal");
		}else {System.out.println("set1 and set3 are not equal");}
		
		
		//Testing the contains() method 
		if (set1.contains(2)) {
			System.out.println("set1 contains the number 2");
		}else {System.out.println("set1 does not contain the number 2");}
		
		//Testing the contains() method 
		if (set1.contains(4)) {
			System.out.println("set1 contains the number 4");
		}else {System.out.println("set1 does not contain the number 4");}
		
		//Testing the largest() method
		try {
			System.out.println("The largest number is set1 is " + set1.largest());
		} catch (IntegerSetException e){System.out.println("The set is empty");}
		
		//Testing the smallest() method 
		try {
			System.out.println("The smallest number is set1 is " + set1.smallest());
		} catch (IntegerSetException e){System.out.println("The set is empty");}
		
		
		//Testing the union() method
		System.out.println("The union between set1 and set2 is: ");
		set1.union(set2);
		
		//Testing the intersect() method
		System.out.println("The intersection between set1 and set2 is: ");
		set1.intersect(set2);
		
		//Testing the diff() method
		System.out.println("The difference between set1 and set2 is: ");
		set1.diff(set2);
		
		//Testing the toString() method
		System.out.println("The string representation of set3 is " + set3.toString());	
		
	}

}
