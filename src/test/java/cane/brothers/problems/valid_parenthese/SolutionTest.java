package cane.brothers.problems.valid_parenthese;

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
    void test_isValid_1() {
        var input = "()";
        assertTrue(sol.isValid(input));
    }

    @Test
    void test_isValid_2() {
        var input = "()[]{}";
        assertTrue(sol.isValid(input));
    }

    @Test
    void test_isValid_3() {
        var input = "(]";
        assertFalse(sol.isValid(input));
    }

    @Test
    void test_isValid_4() {
        var input = "({]}[)";
        assertFalse(sol.isValid(input));
    }
}