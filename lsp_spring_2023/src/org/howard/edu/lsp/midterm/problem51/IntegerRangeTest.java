package org.howard.edu.lsp.midterm.problem51;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.howard.edu.hw5.IntegerSetException;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

public class IntegerRangeTest {
	

    @Test
    @DisplayName("Test for contains")
    public void testContains() {
        IntegerRange range = new IntegerRange(10, 20);
        assertTrue(range.contains(10));
        assertTrue(range.contains(20));
        assertTrue(range.contains(15));
        assertFalse(range.contains(5));
        assertFalse(range.contains(25));
    }

    @Test
    @DisplayName("Test for overlaps")
    public void testOverlaps() throws EmptyRangeException {
        IntegerRange range1 = new IntegerRange(10, 20);
        IntegerRange range2 = new IntegerRange(15, 25);
        IntegerRange range3 = new IntegerRange(25, 30);

        assertTrue(range1.overlaps(range2));
        assertTrue(range2.overlaps(range1));
        assertFalse(range1.overlaps(range3));
        assertFalse(range3.overlaps(range1));
    }

    @Test()
    @DisplayName("Test for overlaps - null")
    public void testOverlapsWithNull() throws EmptyRangeException {
        IntegerRange range = new IntegerRange(10, 20);
        Throwable exception = assertThrows(EmptyRangeException.class, () -> range.overlaps(null));
        assertEquals("Empty Range", exception.getMessage());
    }
    

    @Test
    @DisplayName("Test for size")
    public void testSize() {
        IntegerRange range1 = new IntegerRange(10, 20);
        IntegerRange range2 = new IntegerRange(20, 30);
        IntegerRange range3 = new IntegerRange(-10, 10);

        assertEquals(11, range1.size());
        assertEquals(11, range2.size());
        assertEquals(21, range3.size());
    }
}

