package cane.brothers.problems.remove_negatives;

import java.util.List;
import java.util.Objects;

public class Solution {

    public static void removeNegatives(List<Integer> numbers) {
        Objects.requireNonNull(numbers);

        numbers.removeIf(n -> n < 0);

        // with iterators
//        var it = numbers.iterator();
//        while (it.hasNext()) {
//            var val = it.next();
//            if (val < 0) {
//                it.remove();
//            }
//        }
    }
}
