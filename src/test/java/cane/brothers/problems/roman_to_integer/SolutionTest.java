package cane.brothers.problems.roman_to_integer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void romanToInt_III() {
    String roman = "III";
    Solution sol = new Solution();
    int result = sol.romanToInt(roman);
    assertEquals(3, result);
  }

  @Test
  void romanToInt_LVIII() {
    String roman = "LVIII";
    Solution sol = new Solution();
    int result = sol.romanToInt(roman);
    assertEquals(58, result);
  }

  @Test
  void romanToInt_MCMXCIV() {
    String roman = "MCMXCIV";
    Solution sol = new Solution();
    int result = sol.romanToInt(roman);
    assertEquals(1994, result);
  }

  @Test
  void romanToInt_IA() {
    String roman = "IA";
    Solution sol = new Solution();
    IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () ->
        sol.romanToInt(roman)
    );
    assertEquals( "roman should contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M')",
        thrown.getMessage());
  }

  @Test
  void romanToInt_null() {
    Solution sol = new Solution();
    NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () ->
        sol.romanToInt(null)
    );
    assertEquals("roman should not be empty", thrown.getMessage());
  }

  @Test
  void romanToInt_empty() {
    Solution sol = new Solution();
    Assertions.assertThrows(IllegalArgumentException.class, () ->
        sol.romanToInt("")
    );
  }
}