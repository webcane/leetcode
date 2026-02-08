package cane.brothers.problems.container_with_most_water;

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
    void test_maxArea() {
        var input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        var result = sol.maxArea(input);
        assertEquals(49, result);
    }

    @Test
    void test_maxArea_2() {
        var input = new int[]{1, 1};
        var result = sol.maxArea(input);
        assertEquals(1, result);
    }
}