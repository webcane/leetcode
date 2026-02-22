package cane.brothers.problems.intersection_of_two_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * 349. Intersection of Two Arrays
 * <p>
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 */

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        validateInput(nums1, nums2);

        return withTwoPointers(nums1, nums2);
//        return withSet(nums1, nums2);
    }

    private int[] withTwoPointers(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        var result = new ArrayList<Integer>();
        while (i < nums1.length && j < nums2.length) {
            var one = nums1[i];
            var two = nums2[j];
            if (one == two) {
                if (!result.contains(one)) {
                    result.add(one);
                }
                i++;
                j++;
            } else if (one < two) {
                i++;
            } else {
                j++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int[] withSet(int[] nums1, int[] nums2) {
        var set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());

        var set2 = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        set1.retainAll(set2);
        return set1.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void validateInput(int[] nums1, int[] nums2) {
        /**
         * Constraints:
         *
         * 1 <= nums1.length, nums2.length <= 1000
         * 0 <= nums1[i], nums2[i] <= 1000
         */
    }
}
