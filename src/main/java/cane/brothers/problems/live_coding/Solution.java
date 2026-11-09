package cane.brothers.problems.live_coding;

import java.util.Map;
import java.util.Objects;

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

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxKey == null || entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}
