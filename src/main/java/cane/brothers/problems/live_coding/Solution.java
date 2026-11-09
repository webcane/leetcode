package cane.brothers.problems.live_coding;

import java.util.Map;
import java.util.Objects;

public class Solution {

    //
    public static void removeZeroValues(Map<String, Integer> map) {
        Objects.requireNonNull(map);

        for (var it = map.entrySet().iterator(); it.hasNext(); ) {
            var entry = it.next();

            if (entry.getValue() == 0) {
                it.remove();
            }
        }
    }
}
