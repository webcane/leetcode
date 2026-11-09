package cane.brothers.problems.live_coding;

import java.util.*;

public class Solution {

    //
    public static void removeZeroValues(Map<String, Integer> map) {
        Objects.requireNonNull(map);

        // map.entrySet().removeIf(entry -> entry.getValue() == 0);
        for (var it = map.entrySet().iterator(); it.hasNext(); ) {
            var entry = it.next();

            if (entry.getValue() == 0) {
                it.remove();
            }
        }
    }

    public static String keyOfMaxValue(Map<String, Integer> map) {
        Objects.requireNonNull(map);

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (var entry : map.entrySet()) {
            if (maxKey == null || entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }


    public static Integer findMin(List<Integer> numbers) {
        Objects.requireNonNull(numbers);

        Integer minValue = null;
        for (var number : numbers) {
            if (minValue == null || minValue > number) {
                minValue = number;
            }
        }
        return minValue;
    }

    public static Integer findMax(int[] arr) {
        Objects.requireNonNull(arr);

        Integer maxValue = null;

        for (int number : arr) {
            if (maxValue == null || maxValue < number) {
                maxValue = number;
            }
        }
        return maxValue;
    }

    public static String longestWord(List<String> words) {
        Objects.requireNonNull(words);

        String longest = null;

        for (String word : words) {
            if (longest == null || word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public static String mostFrequent(String[] words) {
        Objects.requireNonNull(words);

        String freq = null;
        int maxFreq = 0;

        var counts = new HashMap<String, Integer>();
        for (String w : words) {
            int cur = counts.getOrDefault(w, 0) + 1;
            counts.put(w, cur);
            if (cur > maxFreq) {
                maxFreq = cur;
                freq = w;
            }
        }
        return freq;
    }


    public static Map<Integer, List<String>> groupByLength(String[] words) {
        Objects.requireNonNull(words);

        Map<Integer, List<String>> counts = new HashMap<>();
        for (String word : words) {
            Integer key = word.length();
            counts.computeIfAbsent(key, v -> new ArrayList<>()).add(word);
        }
        return counts;
    }

    public static void sortByLength(List<String> words) {
        Objects.requireNonNull(words);

        words.sort(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()));
    }


    public static void sortByLengthDescending(List<String> words) {
        Objects.requireNonNull(words);
        words.sort(Comparator.comparingInt(String::length).reversed()
                .thenComparing(Comparator.naturalOrder()));
    }

}
