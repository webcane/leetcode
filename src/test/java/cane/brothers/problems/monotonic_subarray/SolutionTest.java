package cane.brothers.problems.monotonic_subarray;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private Solution sol;

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 3, 1, 2}, 4),
                Arguments.of(new int[]{5, 6, 7, 2, 1}, 3),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, 1),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1}, 6),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{42}, 1),
                Arguments.of(new int[]{1, 2}, 2),
                Arguments.of(new int[]{2, 1}, 1),
                Arguments.of(new int[]{1, 2, 2}, 3),
                Arguments.of(new int[]{1, 2, 2, 2}, 4)
        );
    }

    @BeforeEach
    void setUp() {
        sol = new Solution();
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testLongestNonDecreasingSubarray(int[] input, int expected) {
        assertEquals(expected, sol.longestNonDecreasingSubarray(input));
    }
}
