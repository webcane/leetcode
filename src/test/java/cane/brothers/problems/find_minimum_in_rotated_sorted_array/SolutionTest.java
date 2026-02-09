package cane.brothers.problems.find_minimum_in_rotated_sorted_array;

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
    void test_findMin_1() {
        // Input
        int[] matrix = {3, 4, 5, 1, 2};
        assertEquals(1, sol.findMin(matrix));
    }

    @Test
    void test_findMin_2() {
        // Input
        int[] matrix = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(0, sol.findMin(matrix));

    }

    @Test
    void test_findMin_3() {
        // Input
        int[] matrix = {11,13,15,17};
        assertEquals(11, sol.findMin(matrix));
    }
}