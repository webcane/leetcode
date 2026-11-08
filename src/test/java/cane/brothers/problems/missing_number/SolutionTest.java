package cane.brothers.problems.missing_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    private final Solution sol = new Solution();

    @Test
    void test_example_3_0_1() {
        assertEquals(2, sol.missingNumber(new int[]{3, 0, 1}));
    }

    @Test
    void test_example_0_1() {
        assertEquals(2, sol.missingNumber(new int[]{0, 1}));
    }

    @Test
    void test_example_long_array() {
        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        assertEquals(8, sol.missingNumber(nums));
    }

    @Test
    void test_single_zero_missing_one() {
        assertEquals(1, sol.missingNumber(new int[]{0}));
    }

    @Test
    void test_single_one_missing_zero() {
        assertEquals(0, sol.missingNumber(new int[]{1}));
    }

    @Test
    void test_missing_zero_two_elements() {
        assertEquals(0, sol.missingNumber(new int[]{1, 2}));
    }

    @Test
    void test_missing_middle_unsorted() {
        assertEquals(1, sol.missingNumber(new int[]{2, 0}));
    }

    @Test
    void test_missing_last() {
        assertEquals(4, sol.missingNumber(new int[]{0, 1, 2, 3}));
    }

    @Test
    void test_missing_first() {
        assertEquals(0, sol.missingNumber(new int[]{4, 3, 2, 1}));
    }

    @Test
    void test_upper_bound_n_equals_10_000() {
        int n = 10_000;
        int[] nums = new int[n];
        int missing = 5_000;
        int idx = 0;
        for (int i = 0; i <= n; i++) {
            if (i != missing) {
                nums[idx++] = i;
            }
        }
        assertEquals(missing, sol.missingNumber(nums));
    }

    @Test
    void test_null_array_rejected() {
        assertThrows(IllegalArgumentException.class, () -> sol.missingNumber(null));
    }

    @Test
    void test_empty_array_rejected() {
        assertThrows(IllegalArgumentException.class, () -> sol.missingNumber(new int[]{}));
    }

    @Test
    void test_value_out_of_range_rejected() {
        assertThrows(IllegalArgumentException.class, () -> sol.missingNumber(new int[]{0, 5}));
    }

    @Test
    void test_negative_value_rejected() {
        assertThrows(IllegalArgumentException.class, () -> sol.missingNumber(new int[]{0, -1}));
    }

    @Test
    void test_duplicates_rejected() {
        assertThrows(IllegalArgumentException.class, () -> sol.missingNumber(new int[]{1, 1, 2}));
    }
}