package cane.brothers.problems.reverse_inplace;

import java.util.Objects;

public class Solution {

    public static void reverse(int[] arr) {
        Objects.requireNonNull(arr);

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }
}
