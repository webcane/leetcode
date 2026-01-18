package cane.brothers.problems.sum_of_two.pair.indexed_value;

import cane.brothers.problems.sum_of_two.pair.ArrayValidator;
import cane.brothers.problems.sum_of_two.pair.Pair;

import java.util.*;

/**
 * Hash-based implementation of PairFinder.
 * Follows Single Responsibility Principle (SRP) - only finds pairs.
 * Follows Open/Closed Principle (OCP) - can be extended without modification.
 * Follows Dependency Inversion Principle (DIP) - depends on abstraction (PairFinder interface).
 */
record HashMapTargetPairFinder(ArrayValidator validator) implements TargetPairFinder {

    public HashMapTargetPairFinder() {
        this(new ArrayValidator());
    }

    @Override
    public Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> findPairs(int[] nums, int target) {
        validator.validate(nums);

        Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> result = new HashSet<>();
        Map<Integer, List<Integer>> seenMap = new HashMap<>();

        // Single pass: check for complement and add current element
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            int complement = target - currentValue;

            // Check if complement exists in already seen elements
            if (seenMap.containsKey(complement)) {
                // Add all pairs with previous indices
                for (int j : seenMap.get(complement)) {
                    var first = new IndexedValue<>(j, complement);
                    var second = new IndexedValue<>(i, currentValue);
                    result.add(new Pair<>(first, second));
                }
            }

            // Add current element to the map for future lookups
            seenMap.computeIfAbsent(currentValue, k -> new ArrayList<>()).add(i);
        }

        return result;
    }
}

