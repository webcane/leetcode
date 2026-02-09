package cane.brothers.problems.search_a_2d_matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution sol;

    @BeforeEach
    void setUp() {
        sol = new Solution();
    }

    @Test
    void searchMatrix_pos() {
        // Input
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;

        assertEquals(true, sol.searchMatrix(matrix, target));
    }

    @Test
    void searchMatrix_neg() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 13;

        assertEquals(false, sol.searchMatrix(matrix, target));
    }
}