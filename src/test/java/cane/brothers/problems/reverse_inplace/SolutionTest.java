package cane.brothers.problems.reverse_inplace;

import org.junit.jupiter.api.Test;

import static cane.brothers.problems.reverse_inplace.Solution.reverse;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test_reverseList_1() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        reverse(arr);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, arr);
    }
}