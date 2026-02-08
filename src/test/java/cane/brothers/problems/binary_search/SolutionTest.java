package cane.brothers.problems.binary_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution sol;

    @BeforeEach
    void setUp() {
        sol = new Solution();
    }

    @Test
    void test_search_pos() {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        assertEquals(4, sol.search(nums, target));
    }

    @Test
    void test_search_neg() {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 2;
        assertEquals(-1, sol.search(nums, target));
    }
}