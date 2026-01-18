package cane.brothers.problems.sum_of_two.pair.indexed_value;

import cane.brothers.problems.sum_of_two.pair.Pair;

import java.util.Set;

/**
 * Interface for finding pairs that sum to a target value.
 * Follows Interface Segregation Principle (ISP) and Dependency Inversion Principle (DIP).
 */
interface TargetPairFinder {
    /**
     * Find all unique pairs of IndexedValue objects where each indexed_value contains both index and value:
     * (IndexedValue(i, nums[i]), IndexedValue(j, nums[j]))
     * such that nums[i] + nums[j] == target and i < j.
     *
     * @param nums The array of numbers to find pairs in.
     * @param target The target sum to find pairs for.
     * @return A set of unique pairs containing index and value information.
     */
    Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> findPairs(int[] nums, int target);
}

