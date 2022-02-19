package cane.brothers.problems.move_zeroes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void moveZeroes() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        Solution sol = new Solution();
        sol.moveZeroes(nums);
        assertEquals("[1, 3, 12, 0, 0]", outContent.toString());
    }

    @Test
    void moveZeroes_zeroAtTheEnd() {
        int[] nums = new int[]{0, 1, 0, 3, 0, 12, 0};
        Solution sol = new Solution();
        sol.moveZeroes(nums);
        assertEquals("[1, 3, 12, 0, 0, 0, 0]", outContent.toString());
    }
}