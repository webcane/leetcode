package cane.brothers.problems.monotonic_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isMonotonic_increase() {
        int[] nums = new int[]{1, 2, 2, 3};
        Solution sol = new Solution();
        assertTrue(sol.isMonotonic(nums));
    }

    @Test
    void isMonotonic_descrease() {
        int[] nums = new int[]{6, 5, 5, 4};
        Solution sol = new Solution();
        assertTrue(sol.isMonotonic(nums));
    }

    @Test
    void isMonotonic_nonMonotonic() {
        int[] nums = new int[]{1, 2, 4, 3};
        Solution sol = new Solution();
        assertFalse(sol.isMonotonic(nums));
    }

    @Test
    void isMonotonic_increaseNegative() {
        int[] nums = new int[]{-1, -2, -2, -3};
        Solution sol = new Solution();
        assertTrue(sol.isMonotonic(nums));
    }

    @Test
    void isMonotonic_nonMonotonicNegative() {
        int[] nums = new int[]{-1, -4, -2, -3};
        Solution sol = new Solution();
        assertFalse(sol.isMonotonic(nums));
    }
}