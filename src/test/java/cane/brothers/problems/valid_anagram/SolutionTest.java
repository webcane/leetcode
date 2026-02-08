package cane.brothers.problems.valid_anagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    Solution sol;

    @BeforeEach
    void setUp() {
        sol = new Solution();
    }

    @Test
    void test_isAnagram_pos() {
        String s = "anagram", t = "nagaram";
        assertTrue(sol.isAnagram(s, t));
    }

    @Test
    void test_isAnagram_neg() {
        String s = "rat", t = "car";
        assertFalse(sol.isAnagram(s, t));
    }

}