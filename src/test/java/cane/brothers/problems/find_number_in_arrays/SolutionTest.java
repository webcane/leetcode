package cane.brothers.problems.find_number_in_arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findCommonElement() {
        int[] nums1 = new int[]{1, 2, 4, 5};
        int[] nums2 = new int[]{3, 3, 4};
        int[] nums3 = new int[]{2, 3, 4, 5, 6};
        Solution sol = new Solution();
        int result = sol.findCommonElement(nums1, nums2, nums3);
        assertEquals(4, result);
    }
}