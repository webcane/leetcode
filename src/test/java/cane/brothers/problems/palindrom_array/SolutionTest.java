package cane.brothers.problems.palindrom_array;

import org.junit.jupiter.api.Test;

import static cane.brothers.problems.palindrom_array.Solution.isPalindrome;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test_isPalindrome() {
        assertTrue(isPalindrome(new int[]{1, 2, 3, 2, 1}));
        assertTrue(isPalindrome(new int[]{7}));
        assertTrue(isPalindrome(new int[]{}));

        assertFalse(isPalindrome(new int[]{1, 2, 3}));
    }
}