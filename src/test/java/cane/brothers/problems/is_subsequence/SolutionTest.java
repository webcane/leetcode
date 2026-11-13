package cane.brothers.problems.is_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test_is_subsequence() {
        assertTrue(Solution.is_subsequence("crocodile", "crdle"));
        assertFalse(Solution.is_subsequence("crocodile", "cdleee"));
    }
}