package cane.brothers.problems.sum_of_two;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testSumOfTwo() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Optional<List<int[]>> result = solution.sumOfTwo(nums, target);
        assert(result.isPresent());
        List<int[]> pairs = result.get();
        assert(pairs.size() == 1);
        assert(pairs.get(0)[0] == 0 && pairs.get(0)[1] == 1);
    }
}