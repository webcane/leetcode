package cane.brothers.problems.sum_of_two.pair;

import java.util.*;

/**
 * Hash-based implementation of TargetFinder.
 * Returns pairs of indices where array values sum to target.
 * Follows Single Responsibility Principle (SRP) - only finds pairs.
 * Follows Open/Closed Principle (OCP) - can be extended without modification.
 * Follows Dependency Inversion Principle (DIP) - depends on abstraction (TargetFinder interface).
 */
record HashTargetFinder() implements TargetFinder {

    @Override
    public Set<Pair<Integer, Integer>> findPairs(int[] nums, int target) {
        Set<Pair<Integer, Integer>> result = new HashSet<>();
        Map<Integer, List<Integer>> seenMap = new HashMap<>();

        // Single pass: check for complement and add current element
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            int complement = target - currentValue;

            // Check if complement exists in already seen elements
            if (seenMap.containsKey(complement)) {
                // Add all pairs with previous indices
                for (int j : seenMap.get(complement)) {
                    result.add(new Pair<>(j, i));
                }
            }

            // Add current element to the map for future lookups
            seenMap.computeIfAbsent(currentValue, k -> new ArrayList<>()).add(i);
        }

        return result;
    }
}

