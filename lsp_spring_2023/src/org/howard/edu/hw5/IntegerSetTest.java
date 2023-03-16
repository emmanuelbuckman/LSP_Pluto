package org.howard.edu.hw5;

import org.howard.edu.hw5.IntegerSet;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class IntegerSetTest {

	private IntegerSet set;
	
	@BeforeEach
	void setUp() {
		set = new IntegerSet();
	}
	
	
	@Test
	@DisplayName("Test for clear()")
	public void testClear() {
		set.add(1);
		set.add(6);
		set.clear();
		assertEquals(set.length(), 0);
		set.clear();
		assertEquals(set.length(), 0);
	}
	
	
	@Test
	@DisplayName("Test length")
	public void testLength() {
		set.add(1);
		set.add(2);
		assertEquals(set.length(), 2);
	}
	
	
	@Test
	@DisplayName("Test length - empty set")
	public void testLengthEmpty() {
		
		assertEquals(set.length(), 0);
	}
	
	
	@Test
	@DisplayName("Test equals - true")
	public void testEquals() {
		set.add(1);
		set.add(2);
		set.add(3);
		
		IntegerSet set2 = new IntegerSet();
		set2.add(3);
		set2.add(1);
		set2.add(2);
		
		assertTrue(set.equals(set2));	
	}
	
	
	@Test
	@DisplayName("Test equals - false")
	public void testEqualsFalse() {
		set.add(1);
		set.add(2);
		set.add(3);
		
		IntegerSet set2 = new IntegerSet();
		set2.add(3);
		set2.add(1);
		set2.add(4);
		
		assertFalse(set.equals(set2));	
	}
	
	
	@Test
	@DisplayName("Test contains - true")
	public void testContainsTrue() {
		set.add(1);
		set.add(2);
		
		assertTrue(set.contains(2));
	}
	
	
	@Test
	@DisplayName("Test contains - false")
	public void testContainsFalse() {
		set.add(1);
		set.add(2);
		
		assertFalse(set.contains(3));
	}
	
	
	@Test
	@DisplayName("Test largest")
	public void testLargest() throws IntegerSetException{
		set.add(0);
		set.add(1);
		set.add(4);
		
		assertEquals(set.largest(), 4);
	}
	
	
	@Test
	@DisplayName("Test largest - Exception")
	public void testLargestException() throws IntegerSetException{
		Throwable exception = assertThrows(IntegerSetException.class, () -> set.largest());
		assertEquals("The set is empty", exception.getMessage());
	}
	
	
	@Test
	@DisplayName("Test smallest")
	public void testSmallest() throws IntegerSetException {
		set.add(5);
		set.add(3);
		set.add(1);
		
		assertEquals(set.smallest(), 1);
	}
	
	
	@Test
	@DisplayName("Test smallest - Exception")
	public void testSmallestException() throws IntegerSetException {
		Throwable exception = assertThrows(IntegerSetException.class, () -> set.smallest());
		assertEquals("The set is empty", exception.getMessage());
	}
	
	
	@Test
	@DisplayName("Test add")
	public void testAdd() {
		set.add(1);
		
		assertEquals(set.length(), 1);
	}
	
	
	@Test
	@DisplayName("Test remove")
	public void testRemove() {
		set.add(1);
		set.add(2);
		set.add(3);
		
		set.remove(1);
		
		assertEquals(set.length(), 2);
		
	}
	
	
	@Test
	@DisplayName("Test union")
	public void testUnion() {
		set.add(1);
		set.add(2);
		
		IntegerSet set2 = new IntegerSet();
		set2.add(3);
		set2.add(4);
		
		set.union(set2);
		
		assertEquals(set.toString(), "[1,2,3,4]");
		
	}
	
	
	
	@Test
	@DisplayName("Test intersection")
	public void testIntersection() {
		set.add(1);
		set.add(2);
		
		IntegerSet set2 = new IntegerSet();
		set2.add(2);
		set2.add(3);
		
		set.intersect(set2);
		
		assertEquals(set.toString(), "[2]");
	}
	
	
	@Test
	@DisplayName("Test intersection - multiple")
	public void testIntersectionMultiple() {
		set.add(1);
		set.add(2);
		set.add(3);
		
		IntegerSet set2 = new IntegerSet();
		set2.add(2);
		set2.add(3);
		set2.add(4);
		
		set.intersect(set2);
		
		assertEquals(set.toString(), "[2,3]");
	}
	
	
	@Test
	@DisplayName("Test difference")
	public void testDifference() {
		set.add(1);
		set.add(2);
		set.add(3);
		
		IntegerSet set2 = new IntegerSet();
		set2.add(2);
		set2.add(4);
		
		set.diff(set2);
		
		assertEquals(set.toString(), "[1,3]");
	}
	
	
	@Test
	@DisplayName("Test isEmpty - empty")
	public void testIsEmpty() {
		
		assertTrue(set.isEmpty());
	}
	
	
	@Test
	@DisplayName("Test isEmpty - not empty")
	public void testIsNotEmpty() {
		set.add(1);
		
		assertFalse(set.isEmpty());
	}
	
	
	@Test
	@DisplayName("Test toString")
	public void testToString() {
		set.add(2);
		set.add(4);
		set.add(6);
		
		assertEquals(set.toString(), "[2,4,6]");
	}
	

}
