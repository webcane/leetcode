package cane.brothers.problems.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Solution {

    private static final Map<Character, List<String>> PHONE_MAP = Map.ofEntries(
            Map.entry('2', List.of("a", "b", "c")),
            Map.entry('3', List.of("d", "e", "f")),
            Map.entry('4', List.of("g", "h", "i")),
            Map.entry('5', List.of("j", "k", "l")),
            Map.entry('6', List.of("m", "n", "o")),
            Map.entry('7', List.of("p", "q", "r", "s")),
            Map.entry('8', List.of("t", "u", "v")),
            Map.entry('9', List.of("w", "x", "y", "z")));

    public List<String> letterCombinations(String digits) {
        validateDigits(digits);

        List<String> result = new ArrayList<>();
        if (!digits.isEmpty()) {
            result.add("");
            for (int i = 0; i < digits.length(); i++) {
                Character d = digits.charAt(i);
                result = aggregateLetters(result, PHONE_MAP.get(d));
            }
        }

        System.out.print(result);
        return result;
    }

    private void validateDigits(String digits) {
        if (digits == null) {
            throw new NullPointerException("digits should be given");
        }
        if (digits.length() > 4) {
            throw new IllegalArgumentException("0 <= digits.length <= 4");
        }
        if (!digits.isEmpty() && !digits.matches("[2-9]+")) {
            throw new IllegalArgumentException("digits[i] is a digit in the range ['2', '9']");
        }
    }

    private List<String> aggregateLetters(List<String> pre, List<String> letters) {
        return pre.stream()
                .map(p -> aggregateLetter(p, letters))
                .flatMap(Collection::stream)
                .toList();

    }

    private List<String> aggregateLetter(String pre, List<String> letters) {
        return letters.stream()
                .map(pre::concat)
                .toList();
    }
}
