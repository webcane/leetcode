package cane.brothers.problems.sum_of_two.pair;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TargetTest {

    @Test
    void testTargetRecord() {
        // Test that Target is properly created with target value
        Target target = new Target(9);
        assertEquals(9, target.target());
    }

    @Test
    void testFindPairs_SimplePair() {
        // Given: array with one valid pair
        Target target = new Target(9);
        int[] nums = {2, 7, 11, 15};

        // When
        Set<Pair<Integer, Integer>> result = target.findPairs(nums);

        // Then: should find exactly one pair at indices (0, 1)
        assertEquals(1, result.size());
        Pair<Integer, Integer> pair = result.iterator().next();
        assertEquals(0, pair.first());
        assertEquals(1, pair.second());
    }

    @Test
    void testFindPairs_MultiplePairs() {
        // Given: array with multiple valid pairs
        Target target = new Target(10);
        int[] nums = {1, 9, 2, 8, 3, 7};

        // When
        Set<Pair<Integer, Integer>> result = target.findPairs(nums);

        // Then: should find three pairs: (0,1), (2,3), (4,5)
        assertEquals(3, result.size());

        // Verify all expected pairs are present
        assertTrue(containsPair(result, 0, 1)); // 1 + 9
        assertTrue(containsPair(result, 2, 3)); // 2 + 8
        assertTrue(containsPair(result, 4, 5)); // 3 + 7
    }

    @Test
    void testFindPairs_NoPairs() {
        // Given: array with no valid pairs
        Target target = new Target(100);
        int[] nums = {1, 2, 3, 4, 5};

        // When
        Set<Pair<Integer, Integer>> result = target.findPairs(nums);

        // Then: should return empty set
        assertTrue(result.isEmpty());
    }

    @Test
    void testFindPairs_DuplicateValues() {
        // Given: array with duplicate values that form a pair
        Target target = new Target(6);
        int[] nums = {3, 3};

        // When
        Set<Pair<Integer, Integer>> result = target.findPairs(nums);

        // Then: should find exactly one pair at indices (0, 1)
        assertEquals(1, result.size());
        Pair<Integer, Integer> pair = result.iterator().next();
        assertEquals(0, pair.first());
        assertEquals(1, pair.second());
    }

    @Test
    void testFindPairs_MultipleDuplicates() {
        // Given: array with multiple duplicates forming multiple pairs
        Target target = new Target(10);
        int[] nums = {5, 5, 5, 5};

        // When
        Set<Pair<Integer, Integer>> result = target.findPairs(nums);

        // Then: should find all valid combinations where i < j
        // (0,1), (0,2), (0,3), (1,2), (1,3), (2,3) = 6 pairs
        assertEquals(6, result.size());
    }

    @Test
    void testFindPairs_NegativeNumbers() {
        // Given: array with negative numbers
        Target target = new Target(0);
        int[] nums = {-3, 0, 3, -2, 2};

        // When
        Set<Pair<Integer, Integer>> result = target.findPairs(nums);

        // Then: should find pairs that sum to 0
        assertEquals(2, result.size());
        assertTrue(containsPair(result, 0, 2)); // -3 + 3
        assertTrue(containsPair(result, 3, 4)); // -2 + 2
    }

    @Test
    void testFindPairs_SingleElement() {
        // Given: array with single element (invalid input should be handled by validator)
        Target target = new Target(5);
        int[] nums = {5};

        // When/Then: should throw exception due to array validator
        assertThrows(IllegalArgumentException.class, () -> target.findPairs(nums));
    }

    @Test
    void testFindPairs_EmptyArray() {
        // Given: empty array (invalid input should be handled by validator)
        Target target = new Target(10);
        int[] nums = {};

        // When/Then: should throw exception due to array validator
        assertThrows(IllegalArgumentException.class, () -> target.findPairs(nums));
    }

    @Test
    void testFindPairs_NullArray() {
        // Given: null array
        Target target = new Target(10);

        // When/Then: should throw exception
        assertThrows(NullPointerException.class, () -> target.findPairs(null));
    }

    @ParameterizedTest
    @MethodSource("providePairTestCases")
    void testFindPairs_ParameterizedTests(int[] nums, int targetValue, int expectedPairCount) {
        // Given
        Target target = new Target(targetValue);

        // When
        Set<Pair<Integer, Integer>> result = target.findPairs(nums);

        // Then
        assertEquals(expectedPairCount, result.size());
    }

    private static Stream<Arguments> providePairTestCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, 1),
                Arguments.of(new int[]{3, 2, 4}, 6, 1),
                Arguments.of(new int[]{3, 3}, 6, 1),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 9, 2), // (3,6) and (4,5)
                Arguments.of(new int[]{1, 1, 1, 1}, 2, 6),    // All combinations
                Arguments.of(new int[]{0, 0, 0}, 0, 3),         // (0,1), (0,2), (1,2)
                // Negative numbers test cases
                Arguments.of(new int[]{-1, -2, -3, -4}, -5, 2), // (-1,-4) and (-2,-3)
                Arguments.of(new int[]{-5, 10, -3, 8}, 5, 2),   // (-5,10) and (-3,8)
                Arguments.of(new int[]{-10, -5, 0, 5, 10}, 0, 2), // (-10,10) and (-5,5)
                Arguments.of(new int[]{-1, -1, -1}, -2, 3),     // All combinations of -1 + -1
                Arguments.of(new int[]{-100, 50, 50, -100}, -50, 4), // All combinations: (0,1), (0,2), (1,3), (2,3)
                Arguments.of(new int[]{-7, -3, 2, 5}, -10, 1),  // Only (-7,-3)
                Arguments.of(new int[]{-20, -10, 0, 10, 20}, -20, 1) // Only (-20,0)
        );
    }

    @Test
    void testFindPairs_LargeArray() {
        // Given: larger array with multiple pairs
        Target target = new Target(15);
        int[] nums = {1, 14, 2, 13, 3, 12, 4, 11, 5, 10};

        // When
        Set<Pair<Integer, Integer>> result = target.findPairs(nums);

        // Then: should find all valid pairs
        assertEquals(5, result.size());
        assertTrue(containsPair(result, 0, 1)); // 1 + 14
        assertTrue(containsPair(result, 2, 3)); // 2 + 13
        assertTrue(containsPair(result, 4, 5)); // 3 + 12
        assertTrue(containsPair(result, 6, 7)); // 4 + 11
        assertTrue(containsPair(result, 8, 9)); // 5 + 10
    }

    @Test
    void testFindPairs_OrderDoesNotMatter() {
        // Given: two different arrays with same values in different order
        Target target1 = new Target(10);
        Target target2 = new Target(10);
        int[] nums1 = {1, 9, 2, 8};
        int[] nums2 = {9, 1, 8, 2};

        // When
        Set<Pair<Integer, Integer>> result1 = target1.findPairs(nums1);
        Set<Pair<Integer, Integer>> result2 = target2.findPairs(nums2);

        // Then: should find same number of pairs (though indices may differ)
        assertEquals(2, result1.size());
        assertEquals(2, result2.size());
    }

    // Helper method to check if a pair with specific indices exists
    private boolean containsPair(Set<Pair<Integer, Integer>> pairs, int first, int second) {
        return pairs.stream()
                .anyMatch(pair -> pair.first() == first && pair.second() == second);
    }
}

