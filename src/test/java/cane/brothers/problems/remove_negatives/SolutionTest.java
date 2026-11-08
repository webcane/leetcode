package cane.brothers.problems.remove_negatives;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static cane.brothers.problems.remove_negatives.Solution.removeNegatives;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test_removeNegatives() {
        var numbers = new ArrayList<Integer>(
                List.of(3, -1, 0, -5, 7)
        );

        removeNegatives(numbers);
        assertEquals(List.of(3, 0, 7), numbers); // numbers = [3, 0, 7]
    }
}