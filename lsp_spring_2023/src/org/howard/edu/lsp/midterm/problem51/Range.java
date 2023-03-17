package org.howard.edu.lsp.midterm.problem51;

import org.howard.edu.lsp.midterm.problem51.EmptyRangeException;

public interface Range {
    boolean contains(int value);
    boolean overlaps(Range other) throws EmptyRangeException;
    int size();
}
