package cane.brothers.problems.partition_labels;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears
 * in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such
 * as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 * Return a list of integers representing the size of these parts.
 * Constraints:
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 * Topics:
 * - Hash Table
 * - Two Pointers
 * - String
 * - Greedy
 */
public class Solution {

    public List<Integer> partitionLabels(String s) {
        validateInput(s);
//        return usingMap(s);
//        return classic(s);
        return usingPointer(s);
    }

    /**
     * Для каждой буквы нужно знать её последнее вхождение в строку. Тогда мы можем "расширять" текущий сегмент
     * до тех пор, пока не достигнем последнего вхождения всех букв, находящихся в этом сегменте.
     */
    private List<Integer> classic(String s) {
        var result = new ArrayList<Integer>();

        int[] last = new int[26];

        // Шаг 1: Создаём словарь последних вхождений каждой буквы
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        // Шаг 2: Проходим по строке и формируем сегменты
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);

            // Если достигли конца сегмента
            if (i == end) {
                // Добавляем длину сегмента в результат
                result.add(end - start + 1);
                // Начинаем новый сегмент
                start = i + 1;
            }
        }
        return result;
    }

    private List<Integer> usingMap(String s) {
        var result = new ArrayList<Integer>();
        var last = new java.util.HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            last.put(s.charAt(i), i);
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last.get(s.charAt(i)));
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }

    private List<Integer> usingPointer(String s) {
        var result = new ArrayList<Integer>();

        Pointer p = new Pointer(s);
        for (int i = 0; i < s.length(); i++) {
            p.extendSegment(s.charAt(i));

            if (p.isSegmentFinished(i)) {
                result.add(p.getSegmentLength());
                p.startNewSegment(i);
            }
        }
        return result;
    }

    private void validateInput(String s) {
        if (s == null) {
            throw new NullPointerException("s should be given");
        }

        //
    }

    private static class Pointer {
        private final int[] last = new int[26];
        private int start = 0;
        private int end = 0;

        Pointer(String s) {
            for (int i = 0; i < s.length(); i++) {
                last[s.charAt(i) - 'a'] = i;
            }
        }

        public int getSegmentLength() {
            return end - start + 1;
        }

        public void startNewSegment(int i) {
            start = i + 1;
        }

        public boolean isSegmentFinished(int i) {
            return i == end;
        }

        public void extendSegment(char c) {
            end = Math.max(end, last[c - 'a']);
        }
    }
}
