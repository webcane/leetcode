package cane.brothers.problems.remove_element;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void removeElement() {
        int[] nums = new int[]{3,2,2,3};
        Solution sol = new Solution();
        int result = sol.removeElement(nums, 3);
        assertEquals(2, result);
    }

    @Test
    void removeElement_example2() {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        Solution sol = new Solution();
        int result = sol.removeElement(nums, 2);
        assertEquals(5, result);
    }

}