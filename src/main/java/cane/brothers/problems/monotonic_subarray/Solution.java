package cane.brothers.problems.monotonic_subarray;

public class Solution {

    /**
     * Returns the length of the longest non-decreasing subarray.
     * Finding the length of the longest non-decreasing subarray is useful in scenarios such as:
     * * Analyzing trends in time series data (e.g., stock prices, temperature readings) to find periods of growth
     * or stability.
     * * Identifying the longest sequence of improvements or non-decreasing performance metrics.
     * * Solving algorithmic problems in coding interviews or competitive programming.
     * * Detecting stable or increasing segments in sensor or signal data for further processing.
     * * Optimizing or validating data streams where order or monotonicity is important.
     *
     * @param nums input array
     * @return max length of non-decreasing subarray
     */
    public int longestNonDecreasingSubarray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int maxLen = 1, curLen = 1;

        // Iterate through the array to find the longest non-decreasing subarray
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else {
                curLen = 1;
            }
        }
        return maxLen;
    }
}