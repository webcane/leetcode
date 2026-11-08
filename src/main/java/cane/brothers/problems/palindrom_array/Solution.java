package cane.brothers.problems.palindrom_array;

import java.util.Objects;

public class Solution {

    public static boolean isPalindrome(int[] arr) {
        Objects.requireNonNull(arr);

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
