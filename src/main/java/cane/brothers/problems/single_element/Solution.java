package cane.brothers.problems.single_element;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * Constraints:
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
public class Solution {

    public int getSingleElement(int[] nums) {
//    return classic(nums);
//    return streams(nums);
    return hashMap(nums);
//        return xor(nums);
    }

    private int xor(int[] nums) {
        int result = 0;
        for (int num : nums) {
            // magic
            result ^= num;
        }
        return result;
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

    private int hashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.compute(n, (key, val) -> (val == null) ? 1 : ++val);
        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
