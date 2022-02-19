package cane.brothers.problems.palindrome_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    @Test
    void isPalindrome() {
        Solution sol = new Solution();
        assertTrue(sol.isPalindrome(121));
    }

    @Test
    void isPalindrome_negativeNumber() {
        Solution sol = new Solution();
        assertFalse(sol.isPalindrome(-121));
    }
}