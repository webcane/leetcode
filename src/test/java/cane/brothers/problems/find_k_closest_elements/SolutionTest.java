package cane.brothers.problems.find_k_closest_elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    Solution sol;

    @BeforeEach
    void setUp() {
        sol = new Solution();
    }

    @Test
    void test_findClosestElements_1() {
        var arr = new int[]{1, 2, 3, 4, 5};
        var k = 4;
        var x = 3;
        var result = sol.findClosestElements(arr, k, x);
        assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }

    @Test
    void test_findClosestElements_2() {
        var arr = new int[]{1, 1, 2, 3, 4, 5};
        var k = 4;
        var x = -1;
        var result = sol.findClosestElements(arr, k, x);
        assertArrayEquals(new int[]{1, 1, 2, 3}, result);
    }
}