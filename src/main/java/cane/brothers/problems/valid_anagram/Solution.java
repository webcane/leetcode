package cane.brothers.problems.valid_anagram;

import java.util.Arrays;

public class Solution {

    public boolean isAnagram(String s, String t) {
        validateInput(s, t);

        return withKey(s, t);
    }

    private boolean withKey(String s, String t) {
        return toAnagramKey(s).equals(toAnagramKey(t));
    }

    private void validateInput(String s, String t) {
        if (s == null) {
            throw new NullPointerException("s should not be empty");
        }
        if (t == null) {
            throw new NullPointerException("s should not be empty");
        }
        // TODO
    }

    private String toAnagramKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
