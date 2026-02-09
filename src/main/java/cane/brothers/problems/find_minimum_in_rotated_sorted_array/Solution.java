package cane.brothers.problems.find_minimum_in_rotated_sorted_array;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * Topics:
 * - Array
 * - Binary Search
 */
public class Solution {
    public int findMin(int[] nums) {
        validateInput(nums);

        return searchMin(nums);
    }

    private int searchMin(int[] nums) {
        int leftPos = 0;
        int left = nums[leftPos];

        int rightPos = nums.length - 1;
        int right = nums[rightPos];

        int target = left;
        if (left < right) {
            return target;
        } else {
            // left > right
            int midPos = leftPos + (rightPos - leftPos) / 2;
            target = nums[midPos];

            while (target > right) {
                target = nums[++midPos];
            }
        }

        return target;
    }

    private void validateInput(int[] nums) {
        // Constraints:
        //
        //n == nums.length
        //1 <= n <= 5000
        //-5000 <= nums[i] <= 5000
        //All the integers of nums are unique.
        //nums is sorted and rotated between 1 and n times.
    }
}
