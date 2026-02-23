package cane.brothers.problems.longest_substring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findLongestSubstring() {
        var input = "eceba";
        var k = 2;
        Solution sol = new Solution();
        var result = sol.findLongestSubstring(input, k);
        assertEquals(3, result);
    }
}