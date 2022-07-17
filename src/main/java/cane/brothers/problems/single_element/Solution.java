package cane.brothers.problems.single_element;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

  public int getSingleElement(int[] nums) {
//    return classic(nums);
    return streams(nums);
  }

  private int streams(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    IntStream.of(nums)
        .forEach(num -> map.compute(num, (key, val) -> computeOccurrence(val)));

    return map.entrySet().stream()
        .filter(e -> e.getValue() == 1)
        .map(e -> e.getKey())
        .collect(toSingleton());
  }

  private Integer computeOccurrence(Integer val) {
    return (val == null ? 1 : ++val);
  }

  public static <T> Collector<T, ?, T> toSingleton() {
    return Collectors.collectingAndThen(
        Collectors.toList(),
        list -> {
          if (list.size() != 1) {
            throw new IllegalStateException("there is no single element");
          }
          return list.get(0);
        }
    );
  }

  private int classic(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.compute(n, (key, val) -> (val == null) ? 1 : ++val);
    }

    for (Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }
    throw new IllegalStateException("there is no single element");
  }
}
