package cane.brothers.problems.sum_of_two.pair;

import java.util.Set;

/**
 * Interface for finding pairs that sum to a target value.
 * Follows Interface Segregation Principle (ISP) and Dependency Inversion Principle (DIP).
 */
interface TargetFinder {
    /**
     * Find all unique pairs of indices (i, j) such that nums[i] + nums[j] == target and i < j.
     *
     * @param nums The array of numbers to find pairs in.
     * @param target The target sum to find pairs for.
     * @return A set of unique pairs containing indices (i, j) where i < j.
     */
    Set<Pair<Integer, Integer>> findPairs(int[] nums, int target);
}

