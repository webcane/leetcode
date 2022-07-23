package cane.brothers.problems.letter_combinations_of_a_phone_number;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void letterCombinations_2() {
    var digits = "2";
    Solution sol = new Solution();
    var expectedResult = List.of("a", "b", "c");
    assertListEquals(expectedResult, sol.letterCombinations(digits));
  }

  @Test
  void letterCombinations_23() {
    var digits = "23";
    Solution sol = new Solution();
    var expectedResult = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
    assertListEquals(expectedResult, sol.letterCombinations(digits));
  }

  @Test
  void letterCombinations_234() {
    var digits = "234";
    Solution sol = new Solution();
    var expectedResult = Arrays.asList(
        "adg,adh,adi,aeg,aeh,aei,afg,afh,afi,bdg,bdh,bdi,beg,beh,bei,bfg,bfh,bfi,cdg,cdh,cdi,ceg,ceh,cei,cfg,cfh,cfi"
            .split(","));
    assertListEquals(expectedResult, sol.letterCombinations(digits));
  }

  @Test
  void letterCombinations_empty() {
    var digits = "";
    Solution sol = new Solution();
    var expectedResult = new ArrayList<>();
    assertListEquals(expectedResult, sol.letterCombinations(digits));
  }

  private static void assertListEquals(List<?> first, List<?> second) {
    assertTrue(first.size() == second.size() && first.containsAll(second) && second.containsAll(first));
  }
}