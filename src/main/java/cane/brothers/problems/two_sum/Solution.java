package cane.brothers.problems.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to
 * target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * link: <a href="https://leetcode.com/problems/two-sum/">two-sum</a>
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        validateInput(nums, target);

//        return classic(nums, target);
//        return withComplementMap(nums, target);
        return withTwoPointers(nums, target);
    }

    private int[] withTwoPointers(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int complement = nums[left] + nums[right];
            if (complement == target) {
                return new int[]{left, right};
            } else if (complement > 0) {
                if (complement < target) {
                    left++;
                } else {
                    right--;
                }
            } else {
                if (complement > target) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private int[] withComplementMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] classic(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    private void validateInput(int[] nums, int target) {
        if (nums == null) {
            throw new NullPointerException("nums should not be empty");
        }
        if (nums.length < 2 || nums.length > 104) {
            throw new IllegalArgumentException("2 <= nums.length <= 104");
        }
        for (int num : nums) {
            if (num < -1_000_000_000 || num > 1_000_000_000) {
                throw new IllegalArgumentException("-10^9 <= nums[i] <= 10^9");
            }
        }
        if (target < -1_000_000_000 || target > 1_000_000_000) {
            throw new IllegalArgumentException("-10^9 <= target <= 10^9");
        }
    }
}
