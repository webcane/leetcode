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

        return withSort(nums);
//        return twoPointers(nums);
    }

    public int[] withSort(int[] nums) {
        var result = new int[nums.length];
        for(int i = 0; i< nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }

    public int[] twoPointers(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[i] = leftSquare;
                left++;
            } else {
                result[i] = rightSquare;
                right--;
            }
        }

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
