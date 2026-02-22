package cane.brothers.problems.intersection_of_two_arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test_intersection() {
        Solution sol = new Solution();
        var num1 = new int[]{1, 2, 2, 1};
        var num2 = new int[]{2, 2, 2};

        assertArrayEquals(new int[]{2}, sol.intersection(num1, num2));
    }

    @Test
    void test_intersection2() {
        Solution sol = new Solution();
        var num1 = new int[]{4, 9, 5};
        var num2 = new int[]{9, 4, 9, 8, 4};

        assertArrayEquals(new int[]{4, 9}, sol.intersection(num1, num2));
    }
}