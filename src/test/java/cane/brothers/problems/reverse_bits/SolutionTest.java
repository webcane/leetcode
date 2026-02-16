package cane.brothers.problems.reverse_bits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    @CsvSource({
            "43261596, 964176192",
            "2147483644, 1073741822",
    })
    @ParameterizedTest
    void test_reverseBits(int input, int expected) {
        Solution sol = new Solution();
        assertEquals(expected, sol.reverseBits(input));
    }
}