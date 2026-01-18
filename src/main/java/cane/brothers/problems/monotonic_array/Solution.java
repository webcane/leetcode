package cane.brothers.problems.monotonic_array;

public class Solution {
    private static final int MAX_NUM = 100000;

    public boolean isMonotonic(int[] nums) {
        validate(nums);

        boolean incr = true; // flag to check if array is increasing
        boolean decr = true; // flag to check if array is decreasing

        for (int i = 0; i < nums.length - 1; i++) {
            // Calculate the difference between consecutive elements
            int tmp = nums[i] - nums[i + 1];
            incr &= (tmp >= 0);
            decr &= (tmp <= 0);

            // Early exit if both flags are false
            if (!incr && !decr) {
                return false;
            }
        }

        return true;
    }

    private void validate(int[] nums) {
        if (nums == null) {
            throw new NullPointerException("nums should be given");
        }
        if (nums.length == 0 || nums.length > 100000) {
            throw new IllegalArgumentException("1 <= nums.length <= 1000000");
        }
        for (int num : nums) {
            if (num > MAX_NUM || num < -MAX_NUM) {
                throw new IllegalArgumentException("-10^5 <= nums[i] <= 10^5");
            }
        }
    }
}
