package cane.brothers.problems.monotonic_array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Solution {
    private static final int MAX_NUM = 100000;

    public boolean isMonotonic(int[] nums) {
        validate(nums);
//        return withSet(nums);
        return withTwoFlags(nums);
    }

    static Iterable<IntPair> pairwise(int[] arr) {
        return () -> new PairIterator(arr);
    }

    private boolean withSet(int[] nums) {
        var result = new HashSet<Boolean>();
        for (var pair : pairwise(nums)) {
            if (pair.first() == pair.second()) {
                continue;
            }
            result.add(pair.first() < pair.second());
        }
        return result.size() <= 1;

    }


    private boolean withTwoFlags(int[] nums) {
        boolean incr = true; // flag to check if array is increasing
        boolean decr = true; // flag to check if array is decreasing

        for (int i = 0; i < nums.length - 1; i++) {
            // Calculate the difference between consecutive elements
            incr &= (nums[i] >= nums[i + 1]);
            decr &= (nums[i] <= nums[i + 1]);

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
