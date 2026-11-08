package cane.brothers.problems.palindrom_array;

import java.util.Objects;

public class Solution {

    public static boolean isPalindrome(int[] arr) {
        Objects.requireNonNull(arr);

//        return withWhile(arr);
        return withFor(arr);
    }

    private static boolean withFor(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            if (arr[i] != arr[j]) {
                return false;
            }
        }
        return true;
    }

    private static boolean withWhile(int[] arr) {
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
