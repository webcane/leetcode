package cane.brothers.problems.cybersec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution sol;

    @BeforeEach
    void setUp() {
        sol = new Solution();
    }

    @Test
    void test_countCombinations_15() {
        String input = "abacaba";
        var result = sol.countPasswordVariations(input);
        assertEquals(15, result);
    }

    @Test
    void test_countCombinations_1() {
        String input = "aaaaaa";
        var result = sol.countPasswordVariations(input);
        assertEquals(1, result);
    }
}