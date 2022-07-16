package cane.brothers.problems.monotonic_array;

public class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums == null) {
            throw new NullPointerException("nums should be given");
        }

        if (nums.length == 0 || nums.length > 100000) {
            throw new IllegalArgumentException("1 <= nums.length <= 1000000");
        }

        boolean incr = true;
        boolean decr = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 100000 || nums[i] < -100000) {
                throw new IllegalArgumentException("-10^5 <= nums[i] <= 10^5");
            }

            int tmp = nums[i] - nums[i+1];
            incr &= (tmp >= 0);
            decr &= (tmp <= 0);
        }

        return incr || decr;
    }
}
