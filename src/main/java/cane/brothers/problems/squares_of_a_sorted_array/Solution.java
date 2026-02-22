package cane.brothers.problems.squares_of_a_sorted_array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 *
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 */
public class Solution {

    public int[] sortedSquares(int[] nums) {
        validateInput(nums);
        var result = new int[nums.length];
        for(int i = 0; i< nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }

    private void validateInput(int[] nums) {
        // Constraints:
        //
        //1 <= nums.length <= 104
        //-104 <= nums[i] <= 104
        //nums is sorted in non-decreasing order.
    }
}
