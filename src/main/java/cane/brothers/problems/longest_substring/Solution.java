package cane.brothers.problems.longest_substring;

public class Solution {

    /**
     * 340. Longest Substring with At Most K Distinct Characters
     *
     * @param s input string
     * @param k max number of unique characters
     * @return length of max substring with k unique characters
     */
    public int findLongestSubstring(String s, int k) {
//        validateInput(s, k);
        if (s == null || s.isEmpty() || k == 0) return 0;

        int left = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            var rightChar = s.charAt(i);
        }
        // TBD

        return maxLength;
    }

    private void validateInput(String s, int k) {

    }
}
