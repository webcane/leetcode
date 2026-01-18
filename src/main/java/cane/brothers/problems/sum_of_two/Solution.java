package cane.brothers.problems.sum_of_two;

import java.util.*;

public class Solution {
    public Optional<List<int[]>> sumOfTwo(int[] nums, int target) {
        if (nums == null) {
            throw new NullPointerException("nums should be given");
        }

        if (nums.length < 1 || nums.length > 10_000) {
            throw new IllegalArgumentException("1 <= nums.length, nums.length <= 10^4");
        }

        // Проход 1: строим карту значений -> индексы
        Map<Integer, List<Integer>> seenMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            seenMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Проход 2: ищем пары
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (seenMap.containsKey(complement)) {
                for (int j : seenMap.get(complement)) {
                    // Избегаем дубликатов
                    if (i < j) {
                        result.add(new int[]{i, j});
                    }
                }
            }
        }

        return result.isEmpty() ? Optional.empty() : Optional.of(result);
    }
}
