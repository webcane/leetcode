package cane.brothers.problems.unique_count;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution sol;

    @BeforeEach
    void setUp() {
        sol = new Solution();
    }

    @AfterEach
    void tearDown() {
        // no resources to clean up
    }

    static Stream<Arguments> uniqueCountCases() {
        return Stream.of(
            Arguments.of(new int[]{}, 0),
            Arguments.of(new int[]{42}, 1),
            Arguments.of(new int[]{1,2,3,4,5}, 5),
            Arguments.of(new int[]{1,2,2,3,3,3}, 3),
            Arguments.of(new int[]{-1,-2,-2,0,1}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("uniqueCountCases")
    void testCountUnique(int[] input, int expected) {
        assertEquals(expected, sol.countUnique(input));
    }

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> sol.countUnique(null));
    }
}