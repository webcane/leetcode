package cane.brothers.problems.find_number_in_arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int findNumberInArrays(int[] ... nums) {
        if (nums == null) {
            throw new NullPointerException("nums should be given");
        }

        if (nums.length == 0 || nums.length > 100) {
            throw new IllegalArgumentException("1 <= nums.length <= 100");
        }

        List<Integer> result = Arrays.stream(nums[0]).boxed().collect(Collectors.toList());

        for (int i = 1; i < nums.length; i++) {
            for(Iterator<Integer> iter = result.iterator(); iter.hasNext();) {
                Integer n = iter.next();
                if (Arrays.stream(nums[i]).noneMatch(num -> num == n)) {
                    iter.remove();
                }
            }
        }

        if (result.size() == 1) {
            return result.get(0).intValue();
        }
        throw new RuntimeException("There is no unique result");
    }
}
