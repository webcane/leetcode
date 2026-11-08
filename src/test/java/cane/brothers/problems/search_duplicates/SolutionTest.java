package cane.brothers.problems.search_duplicates;

import org.junit.jupiter.api.Test;

import static cane.brothers.problems.search_duplicates.Solution.containsDuplicate;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test_search_duplicates() {
        assertTrue(containsDuplicate(new int[]{1, 2, 3, 1}));
        assertTrue(containsDuplicate(new int[]{7, 7}));       // true

        assertFalse(containsDuplicate(new int[]{1, 2, 3, 4}));
        assertFalse(containsDuplicate(new int[]{}));           // false
    }
}