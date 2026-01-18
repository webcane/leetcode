package cane.brothers.problems.sum_of_two.pair.indexed_value;

import cane.brothers.problems.sum_of_two.pair.Pair;

/**
 * Represents a value with its index in an array.
 * This is a specialized Pair where first element is always an Integer (index)
 * and second element is the value.
 * Follows Liskov Substitution Principle (LSP) - can be used anywhere a Pair is expected.
 *
 * @param <V> the type of the value
 */
public class IndexedValue<V> extends Pair<Integer, V> {

    public IndexedValue(Integer index, V value) {
        super(index, value);
    }

    /**
     * Gets the index.
     *
     * @return the index
     */
    public Integer index() {
        return first();
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public V value() {
        return second();
    }

    /**
     * Converts this IndexedValue to a basic Pair.
     *
     * @return a Pair containing the index and value
     */
    public Pair<Integer, V> toPair() {
        return new Pair<>(index(), value());
    }

    @Override
    public String toString() {
        return "IndexedValue{index=" + index() + ", value=" + value() + '}';
    }
}

