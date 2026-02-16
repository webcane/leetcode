package cane.brothers.problems.reverse_bits;

/**
 * Reverse bits of a given 32 bits signed integer.
 * Topics
 * - Divide and Conquer
 * - Bit Manipulation
 */
public class Solution {

    public int reverseBits(int n) {
        validateInput(n);

//        return reverseBitsWithShift(n);
        return reverseBits2(n);
    }

    public int reverseBitsWithShift(int n) {
        int rev = 0;
        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            rev |= (n & 1);
            n >>= 1;
        }
        return rev;
    }

    public int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Получаем i-й бит: (n / 2^i) % 2
            int bit = (int) ((n / powerOfTwo(i)) % 2);

            // Добавляем этот бит в позицию (31 - i)
            result += bit * powerOfTwo(31 - i);
        }
        return result;
    }

    // Метод для вычисления 2^exp без сдвигов
    private long powerOfTwo(int exp) {
        long res = 1;
        for (int i = 0; i < exp; i++) {
            res *= 2;
        }
        return res;
    }

    private void validateInput(int n) {
        /*
        Constraints:
            0 <= n <= 231 - 2
            n is even.
        */
    }
}
