package cane.brothers.problems.live_coding;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static cane.brothers.problems.live_coding.Solution.keyOfMaxValue;
import static cane.brothers.problems.live_coding.Solution.removeZeroValues;
import static cane.brothers.problems.search_duplicates.Solution.containsDuplicate;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test_removeZeroValues() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 10);
        map.put("b", 0);
        map.put("c", 20);
        map.put("d", 0);

        removeZeroValues(map); // {a=10, c=20}

        assertEquals(map, Map.of("a", 10, "c", 20));
    }

    @Test
    void test_keyOfMaxValue() {
        Map<String, Integer> map = Map.of(
                "alice", -10,
                "bob", -5,
                "charlie", -20
        );

        assertEquals("bob", keyOfMaxValue(map));
    }


}