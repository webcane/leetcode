package cane.brothers.problems.remove_element;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            throw new NullPointerException("nums should not be empty");
        }

        if (nums.length > 100) {
            throw new IllegalArgumentException("0 <= nums.length <= 100");
        }

        int repId = nums.length;
        int repVal;

        for (int i = 0; i < nums.length; i++) {
            if(repId <= i) {
                break;
            }

            int cur = nums[i];
            if (cur == val) {
                // swap
                do {
                    repVal = nums[--repId];
                }
                while (repId > i && repVal == val);
                nums[i] = repVal;
                nums[repId] = cur;
            }
        }
        return repId;
    }
}
