package cane.brothers.problems.count_frequencies;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {

    public static Map<Integer, Integer> countFrequencies(int[] arr) {
        Objects.requireNonNull(arr);

        var freq = new HashMap<Integer, Integer>();
        for (int el : arr) {
            freq.merge(el, 1, Integer::sum);
            // freq.put(el, freq.getOrDefault(el, 0) + 1);
        }
        return freq;
    }
}
