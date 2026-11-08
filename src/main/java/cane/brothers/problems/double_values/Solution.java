package cane.brothers.problems.double_values;

import java.util.List;
import java.util.Objects;

public class Solution {

    public static void doubleValues(List<Integer> numbers) {
        Objects.requireNonNull(numbers);

        var li = numbers.listIterator();
        while (li.hasNext()) {
            var cur = li.next();
            li.set(cur*2);
        }
    }
}
