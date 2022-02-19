package cane.brothers.problems.two_sum;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            throw new NullPointerException("nums should not be empty");
        }

        if (nums.length < 2 || nums.length > 10000) {
            throw new IllegalArgumentException("1 <= nums.length <= 104");
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if( i == j) {
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
}
