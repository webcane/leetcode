package cane.brothers.problems.count_frequencies;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static cane.brothers.problems.count_frequencies.Solution.countFrequencies;
import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    @Test
    void test_countFrequencies_1() {
        int[] arr = {1, 2, 1, 3, 2, 1};
        Map<Integer, Integer> result = countFrequencies(arr); // {1=3, 2=2, 3=1}
        assertEquals(Map.ofEntries(entry(1, 3), entry(2, 2), entry(3, 1)), result);
    }
}