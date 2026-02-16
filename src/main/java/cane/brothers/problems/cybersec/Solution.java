package cane.brothers.problems.cybersec;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int countPasswordVariations(String s) {
        validateInput(s);
//        return countCombinations(s);
        return linear(s);
    }

    private int linear(String s) {
        int length = s.length();
        Map<Character, Integer> frequency = new HashMap<>();

        // Подсчитываем частоту каждого символа
        for (char ch : s.toCharArray()) {
//            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
            frequency.compute(ch, (c, val) -> val == null ? 1 : val + 1);
        }

        // Общее количество возможных комбинаций по двум элементам
        int totalCombos = (length * (length - 1)) / 2;

        // Отнимаем количество случаев, когда символы совпадают
        for (Integer freq : frequency.values()) {
            if (freq > 1) {
                totalCombos -= (freq * (freq - 1)) / 2;
            }
        }

        // Добавляем начальный пароль
        return totalCombos + 1;
    }

    public int countCombinations(String s) {
        Set<String> result = new HashSet<>();
        result.add(s);

        for (int i = 0; i < s.length(); i++) {
            char one = s.charAt(i);
            for (int j = 1; j < s.length(); j++) {
                char two = s.charAt(j);

                StringBuilder tmp = new StringBuilder(s);
                if (one != two) {
                    tmp.setCharAt(j, one);
                    tmp.setCharAt(i, two);
                    result.add(tmp.toString());
                }
            }
        }
        return result.size();
    }

    private void validateInput(String s) {
        if (s.isEmpty()) throw new IllegalArgumentException("");
    }
}
