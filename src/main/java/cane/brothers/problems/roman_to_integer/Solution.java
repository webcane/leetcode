package cane.brothers.problems.roman_to_integer;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
  public int romanToInt(String roman) {
    if (roman == null) {
      throw new NullPointerException("roman should not be empty");
    }

    if (roman.length() <= 1 && 15 <= roman.length()) {
      throw new IllegalArgumentException("1 <= roman.length <= 15");
    }

    if (!roman.matches("[IVXLCDM]+")) {
      throw new IllegalArgumentException(
          "roman should contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M')");
    }

    Map<Character, Integer> map = new LinkedHashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    int number = 0;
    int prev = 0;

    for (int i = roman.length() - 1; i >= 0; i--) {
      int n = map.get(roman.charAt(i));
      number = number + (prev > n ? -n : n);
      prev = n;
    }

    return number;
  }
}
