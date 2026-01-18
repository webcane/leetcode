package cane.brothers.problems.find_number_in_arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public int findCommonElement(int[]... nums) {
        validateInput(nums);

        // Initialize the result set with elements from the first array
        Set<Integer> result = Arrays.stream(nums[0])
                .boxed()
                .collect(Collectors.toSet());

        // pass through the rest of the arrays and retain only common elements
        for (int i = 1; i < nums.length; i++) {
            Set<Integer> current = Arrays.stream(nums[i])
                    .boxed()
                    .collect(Collectors.toSet());
            result.retainAll(current);

            if (result.isEmpty()) {
                throw new RuntimeException("There is no unique result");
            }
        }

        if (result.size() == 1) {
            return result.iterator().next();
        }
        throw new RuntimeException("There is no unique result");
    }

    private void validateInput(int[][] nums) {
        if (nums == null) {
            throw new NullPointerException("nums should be given");
        }

        if (nums.length == 0 || nums.length > 100) {
            throw new IllegalArgumentException("1 <= nums.length <= 100");
        }
    }
}
