package cane.brothers.problems.single_element;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void getSingleElement_one() {
        int[] nums = new int[]{1, 2, 2, 3, 3};
        Solution sol = new Solution();
        assertEquals(1, sol.getSingleElement(nums), "wrong single element");
    }

    @Test
    void getSingleElement_uno() {
        int[] nums = new int[]{2, 2, 1};
        Solution sol = new Solution();
        assertEquals(1, sol.getSingleElement(nums), "wrong single element");
    }

    @Test()
    void getSingleElement_four() {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        Solution sol = new Solution();
        assertEquals(4, sol.getSingleElement(nums), "wrong single element");

    }
}