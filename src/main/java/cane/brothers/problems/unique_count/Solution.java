package cane.brothers.problems.unique_count;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Returns the number of unique elements in the array in a single pass.
     * @param nums input array
     * @return count of unique elements
     */
    public int countUnique(int[] nums) {
        if (nums == null) {
            throw new NullPointerException("Input array should not be null");
        }
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }
        return unique.size();
    }
}