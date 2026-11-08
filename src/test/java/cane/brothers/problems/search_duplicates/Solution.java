package cane.brothers.problems.search_duplicates;

import java.util.HashSet;

public class Solution {

    public static boolean containsDuplicate(int[] nums) {
        var unique = new HashSet<Integer>();
        for (int i : nums) {
            if (!unique.add(i)) {
                return true;
            }
        }
        return false;
    }
}
