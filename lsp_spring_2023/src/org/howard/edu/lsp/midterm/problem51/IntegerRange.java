package org.howard.edu.lsp.midterm.problem51;

public class IntegerRange implements Range {

    private int lower;
    private int upper;

    public IntegerRange(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }

    @Override
    public boolean contains(int value) {
        return value >= lower && value <= upper;
    }

    @Override
    public boolean overlaps(Range other) throws EmptyRangeException {
        if (other == null) {
            throw new EmptyRangeException("Empty Range");
        }

        return !(this.lower > ((IntegerRange) other).getUpper() || ((IntegerRange) other).getLower() > this.upper);
    }

    @Override
    public int size() {
        return upper - lower + 1;
    }
}

