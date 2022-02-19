package cane.brothers.problems.two_sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    @Test
    void twoSum() {
        int[] nums = new int[]{2,7,11,15};
        Solution sol = new Solution();
        int[] result = sol.twoSum(nums, 9);
        assertArrayEquals(new int[]{0,1}, result);
    }

    @Test
    void twoSum_negativeNumbers() {
        int[] nums = new int[]{-1,-2,-3,-4,-5};
        Solution sol = new Solution();
        int[] result = sol.twoSum(nums, -8);
        assertArrayEquals(new int[]{2,4}, result);
    }
}