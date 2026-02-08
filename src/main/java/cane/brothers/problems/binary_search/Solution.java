package cane.brothers.problems.binary_search;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - -10^4 < nums[i], target < 10^4
 * - All the integers in nums are unique!
 * - nums is sorted in ascending order!
 * Topics:
 * - Array
 * - Binary Search
 */
public class Solution {
    public int search(int[] nums, int target) {
        validateInput(nums, target);
//        return withLinearSearch(nums, target);
//        return binarySearch(nums, target);
        return new BinarySearch(nums).search(target);
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int withLinearSearch(int[] nums, int target) {
        // Time: O(n)
        // Space: O(1)
        var result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result = i;
                break;
            }
        }
        return result;
    }

    private void validateInput(int[] nums, int target) {
    }

    protected static class BinarySearch {
        private final int[] nums;
        private int left;
        private int right;

        public BinarySearch(final int[] nums) {
            this.nums = nums;
            left = 0;
            right = nums.length - 1;
        }

        /**
         * search target position using binary search
         *
         * @param target target number
         * @return position or -1
         */
        public int search(int target) {
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
