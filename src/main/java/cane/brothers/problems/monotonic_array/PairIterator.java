package cane.brothers.problems.monotonic_array;

import java.util.Iterator;
import java.util.NoSuchElementException;

record IntPair(int first, int second) {
}

class PairIterator implements Iterator<IntPair> {
    private int i = 0;
    private final int[] arr;

    PairIterator(int[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return i < arr.length - 1;
    }

    @Override
    public IntPair next() {
        if (!hasNext()) throw new NoSuchElementException();
        return new IntPair(arr[i], arr[i++ + 1]);
    }
}
