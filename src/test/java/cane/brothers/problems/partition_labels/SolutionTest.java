package cane.brothers.problems.partition_labels;

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
    void test_partitionLabels_1() {
        var input = "ababcbacadefegdehijhklij";
        var result = sol.partitionLabels(input);
        assertEquals(result.size(), 3);
        assertEquals(result.get(0), 9);
        assertEquals(result.get(1), 7);
        assertEquals(result.get(2), 8);
    }

    @Test
    void test_partitionLabels_2() {
        var input = "eccbbbbdec";
        var result = sol.partitionLabels(input);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), 10);
    }
}