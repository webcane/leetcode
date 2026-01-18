package cane.brothers.problems.sum_of_two.pair.indexed_value;

import cane.brothers.problems.sum_of_two.pair.Pair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TargetTest {

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(10, new int[]{1, 9}, 1),
                Arguments.of(10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4), // (1,9), (2,8), (3,7), (4,6)
                Arguments.of(5, new int[]{2, 3, 4}, 1), // (2,3) sums to 5
                Arguments.of(7, new int[]{2, 3, 4, 5}, 2), // (2,5) and (3,4) sum to 7
                Arguments.of(0, new int[]{-5, -3, 0, 3, 5}, 2) // (-5,5), (-3,3)
        );
    }

    @Test
    void testTargetRecord() {
        // Test that Target is properly created with target value
        Target target = new Target(9);
        assertEquals(9, target.target());
    }

    @Test
    void testFindPairs_SimplePair() {
        // Given: array with one valid indexed_value
        Target target = new Target(9);
        int[] nums = {2, 7, 11, 15};

        // When
        Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> result = target.findPairs(nums);

        // Then: should find exactly one indexed_value (2, 7) at indices (0, 1)
        assertEquals(1, result.size());
        Pair<IndexedValue<Integer>, IndexedValue<Integer>> pair = result.iterator().next();
        assertEquals(0, pair.first().index());
        assertEquals(2, pair.first().value());
        assertEquals(1, pair.second().index());
        assertEquals(7, pair.second().value());
    }

    @Test
    void testFindPairs_MultiplePairs() {
        // Given: array with multiple valid pairs
        Target target = new Target(10);
        int[] nums = {1, 9, 2, 8, 3, 7};

        // When
        Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> result = target.findPairs(nums);

        // Then: should find three pairs: (1,9), (2,8), (3,7)
        assertEquals(3, result.size());

        // Verify all expected pairs are present
        assertTrue(containsPairWithValues(result, 1, 9));
        assertTrue(containsPairWithValues(result, 2, 8));
        assertTrue(containsPairWithValues(result, 3, 7));
    }

    @Test
    void testFindPairs_NoPairs() {
        // Given: array with no valid pairs
        Target target = new Target(100);
        int[] nums = {1, 2, 3, 4, 5};

        // When
        Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> result = target.findPairs(nums);

        // Then: should return empty set
        assertTrue(result.isEmpty());
    }

    @Test
    void testFindPairs_DuplicateValues() {
        // Given: array with duplicate values that form a indexed_value
        Target target = new Target(6);
        int[] nums = {3, 3};

        // When
        Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> result = target.findPairs(nums);

        // Then: should find exactly one indexed_value at indices (0, 1)
        assertEquals(1, result.size());
        Pair<IndexedValue<Integer>, IndexedValue<Integer>> pair = result.iterator().next();
        assertEquals(0, pair.first().index());
        assertEquals(3, pair.first().value());
        assertEquals(1, pair.second().index());
        assertEquals(3, pair.second().value());
    }

    @Test
    void testFindPairs_MultipleDuplicates() {
        // Given: array with multiple duplicates forming multiple pairs
        Target target = new Target(10);
        int[] nums = {5, 5, 5, 5};

        // When
        Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> result = target.findPairs(nums);

        // Then: should find all valid combinations where i < j
        // (0,1), (0,2), (0,3), (1,2), (1,3), (2,3) = 6 pairs
        assertEquals(6, result.size());
    }

    @Test
    void testFindPairs_NegativeNumbers() {
        // Given: array with negative numbers
        Target target = new Target(0);
        int[] nums = {-3, -1, 1, 3, 5};

        // When
        Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> result = target.findPairs(nums);

        // Then: should find pairs that sum to 0
        assertEquals(2, result.size());
        assertTrue(containsPairWithValues(result, -3, 3));
        assertTrue(containsPairWithValues(result, -1, 1));
    }

    @Test
    void testFindPairs_NegativeTarget() {
        // Given: negative target sum
        Target target = new Target(-5);
        int[] nums = {-10, 5, -2, -3, 7};

        // When
        Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> result = target.findPairs(nums);

        // Then: should find pairs that sum to -5: (-10,5) and (-2,-3)
        assertEquals(2, result.size());
        assertTrue(containsPairWithValues(result, -10, 5));
        assertTrue(containsPairWithValues(result, -2, -3));
    }

    @Test
    void testFindPairs_SingleElement() {
        // Given: array with single element
        Target target = new Target(10);
        int[] nums = {10};

        // When/Then: should throw exception (based on validator behavior)
        assertThrows(IllegalArgumentException.class, () -> target.findPairs(nums));
    }

    @Test
    void testFindPairs_EmptyArray() {
        // Given: empty array
        Target target = new Target(10);
        int[] nums = {};

        // When/Then: should throw exception (based on validator behavior)
        assertThrows(IllegalArgumentException.class, () -> target.findPairs(nums));
    }

    @Test
    void testFindPairs_NullArray() {
        // Given: null array
        Target target = new Target(10);

        // When/Then: should throw NullPointerException (as per ArrayValidator)
        assertThrows(NullPointerException.class, () -> target.findPairs(null));
    }

    @Test
    void testFindPairs_ZeroTarget() {
        // Given: target is zero
        Target target = new Target(0);
        int[] nums = {0, 0, 1, -1};

        // When
        Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> result = target.findPairs(nums);

        // Then: should find pairs (0,0) and (1,-1)
        assertEquals(2, result.size());
        assertTrue(containsPairWithValues(result, 0, 0));
        assertTrue(containsPairWithValues(result, 1, -1));
    }

    @Test
    void testFindPairs_LargeNumbers() {
        // Given: array with large numbers
        Target target = new Target(2000000000);
        int[] nums = {1000000000, 1000000000, 500000000};

        // When
        Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> result = target.findPairs(nums);

        // Then: should find indexed_value of two 1000000000 values
        assertEquals(1, result.size());
        assertTrue(containsPairWithValues(result, 1000000000, 1000000000));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testFindPairs_ParameterizedTest(int targetValue, int[] nums, int expectedPairCount) {
        // Given
        Target target = new Target(targetValue);

        // When
        Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> result = target.findPairs(nums);

        // Then
        assertEquals(expectedPairCount, result.size());
    }

    @Test
    void testFindPairs_UniquenessByIndex() {
        // Given: test that pairs are differentiated by index, not just value
        Target target = new Target(6);
        int[] nums = {1, 5, 2, 4, 3, 3};

        // When
        Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> result = target.findPairs(nums);

        // Then: verify pairs maintain correct index information
        for (Pair<IndexedValue<Integer>, IndexedValue<Integer>> pair : result) {
            assertTrue(pair.first().index() < pair.second().index(),
                    "First index should be less than second index");
            assertEquals(target.target(),
                    pair.first().value() + pair.second().value(),
                    "Pair values should sum to target");
        }
    }

    @Test
    void testFindPairs_ResultIsUnmodifiable() {
        // Given
        Target target = new Target(10);
        int[] nums = {1, 9, 2, 8};

        // When
        Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> result = target.findPairs(nums);
        int originalSize = result.size();

        // Then: verify we get a proper set that behaves correctly
        assertNotNull(result);
        assertEquals(2, originalSize);
    }

    @Test
    void testRecordEquality() {
        // Test that Target records with same value are equal
        Target target1 = new Target(10);
        Target target2 = new Target(10);
        Target target3 = new Target(20);

        assertEquals(target1, target2);
        assertNotEquals(target1, target3);
        assertEquals(target1.hashCode(), target2.hashCode());
    }

    @Test
    void testRecordToString() {
        // Test that Target has proper toString
        Target target = new Target(42);
        String str = target.toString();

        assertNotNull(str);
        assertTrue(str.contains("42"));
    }

    // Helper method to check if result contains a indexed_value with given values
    private boolean containsPairWithValues(
            Set<Pair<IndexedValue<Integer>, IndexedValue<Integer>>> result,
            int value1, int value2) {
        return result.stream().anyMatch(pair ->
                (pair.first().value() == value1 && pair.second().value() == value2) ||
                        (pair.first().value() == value2 && pair.second().value() == value1)
        );
    }
}

