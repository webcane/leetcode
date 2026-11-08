package cane.brothers.problems.missing_number;

/**
 * LeetCode 268 — Missing Number
 * Условие. Дан массив nums из n различных чисел в диапазоне [0, n] (ровно n чисел из n + 1 возможного).
 * Вернуть единственное число из этого диапазона, которого в массиве нет.
 *
 * Примеры:
 * Вход	Выход	Пояснение
 * [3, 0, 1]	2	n = 3, диапазон [0, 3], нет двойки
 * [0, 1]	2	n = 2, нет двойки
 * [9,6,4,2,3,5,7,0,1]	8	n = 9, нет восьмёрки
 * [0]	1	n = 1, диапазон [0, 1]
 * [1]	0	n = 1, нет нуля
 * Ограничения
 * - n == nums.length
 * - 1 <= n <= 10^4
 * - 0 <= nums[i] <= n
 * - все числа в nums уникальны
 * Идеи решения
 * Подход	Время	Память	Замечание
 * Сумма Гаусса n(n+1)/2 − Σnums	O(n)	O(1)	одна строка математики, нужен long от переполнения
 * XOR индексов и значений	O(n)	O(1)	переполнения нет совсем
 * Cyclic sort (на месте)	O(n)	O(1)	меняет входной массив, полезно как тренировка
 */
public class Solution {

    public int missingNumber(int[] nums) {
        validateInput(nums);
        return withGaussSum(nums);
//        return withXor(nums);
    }

    /**
     * Альтернатива без риска переполнения.
     */
    private int withXor(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }

    private int withGaussSum(int[] nums) {
        int n = nums.length;
        long expected = (long) n * (n + 1) / 2;
        long actual = 0;
        for (int num : nums) {
            actual += num;
        }
        return (int) (expected - actual);
    }

    private void validateInput(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums must not be null");
        }
        int n = nums.length;
        if (n < 1) {
            throw new IllegalArgumentException("nums must contain at least one element");
        }
        boolean[] seen = new boolean[n + 1];
        for (int num : nums) {
            if (num < 0 || num > n) {
                throw new IllegalArgumentException("value out of range [0, " + n + "]: " + num);
            }
            if (seen[num]) {
                throw new IllegalArgumentException("duplicate value: " + num);
            }
            seen[num] = true;
        }
    }

}
