package cane.brothers.problems.find_k_closest_elements;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 * <p>
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * An integer a is closer to x than an integer b if:
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 * Topics:
 * Senior Staff
 * Array
 * Two Pointers
 * Binary Search
 * Sliding Window
 * Sorting
 * Heap (Priority Queue)
 */
public class Solution {

    public int[] findClosestElements(int[] arr, int k, int x) {
        validateInput(arr, k, x);

        var left = 0;
        var right = arr.length - 1;
        int[] result = new int[k];

        while (right - left != k) {
            if (x - arr[left] > arr[right] - x) {
                left++;
            } else {
                right--;
            }
        }

        System.arraycopy(arr, left, result, 0, k);
        return result;
    }

    private void validateInput(int[] arr, int k, int x) {
        // Constraints:
        //
        //1 <= k <= arr.length
        //1 <= arr.length <= 104
        //arr is sorted in ascending order.
        //-104 <= arr[i], x <= 104
        if (arr == null || arr.length == 0 || arr.length > 104 || k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid input");
        }

    }
}
