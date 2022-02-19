package cane.brothers.problems.move_zeroes;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            throw new NullPointerException("nums should not be empty");
        }

        if (nums.length == 0 || nums.length > 10000) {
            throw new IllegalArgumentException("1 <= nums.length <= 104");
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    // swap
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
            }
        }
        System.out.print(Arrays.toString(nums));
    }
}
