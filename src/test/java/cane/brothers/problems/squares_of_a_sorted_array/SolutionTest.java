package cane.brothers.problems.squares_of_a_sorted_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test_sortedSquares() {
        var input = new int[]{-4, -1, 0, 3, 10};
        Solution sol = new Solution();
        var result = sol.sortedSquares(input);
        assertArrayEquals(new int[]{0, 1, 9, 16, 100}, result);
    }
}