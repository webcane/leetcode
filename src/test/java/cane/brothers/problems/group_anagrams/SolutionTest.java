package cane.brothers.problems.group_anagrams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution sol;

    @BeforeEach
    public void setUp() {
        sol = new Solution();
    }

    @AfterEach
    public void restore() {

    }

    @Test
    void test_groupAnagrams() {
        String[] strs = List.of("eat", "tea", "tan", "ate", "nat", "bat").toArray(new String[0]);
        var result = sol.groupAnagrams(strs);
        var expected = List.of(
                List.of("bat"),
                List.of("nat", "tan"),
                List.of("ate", "eat", "tea")
        );
        assertEquals(expected.size(), result.size());
    }
}