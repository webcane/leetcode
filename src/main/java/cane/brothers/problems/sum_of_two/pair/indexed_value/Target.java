package cane.brothers.problems.sum_of_two.pair.indexed_value;

import cane.brothers.problems.sum_of_two.pair.Pair;

import java.util.*;

/**
 * Record representing a target sum with functionality to find pairs.
 * Follows Single Responsibility Principle by delegating finding logic to PairFinder.
 * Follows Dependency Inversion Principle by depending on PairFinder abstraction.
 */
public record Target(int target) {

    private static final TargetPairFinder DEFAULT_FINDER = new HashMapTargetPairFinder();

    /**
     * Get all unique pairs of IndexedValue objects where each indexed_value contains both index and value:
     * (IndexedValue(i, nums[i]), IndexedValue(j, nums[j]))
     * such that nums[i] + nums[j] == target and i < j.
     *
     * @param nums The array of numbers to find pairs in.
     * @return A set of unique pairs containing index and value information.
     */
    public Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> findPairs(int[] nums) {
        return DEFAULT_FINDER.findPairs(nums, target);
    }
}
