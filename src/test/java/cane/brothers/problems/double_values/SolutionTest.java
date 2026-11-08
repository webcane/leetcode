package cane.brothers.problems.double_values;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static cane.brothers.problems.double_values.Solution.doubleValues;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    @Test
    void test_doubleValues() {
        var numbers = new ArrayList<>(List.of(1, 2, 3, 4));

        doubleValues(numbers);
        assertEquals(List.of(2, 4, 6, 8), numbers);
    }
}