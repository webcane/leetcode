package cane.brothers.problems.palindrome_number;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int rem, sum = 0;
        int temp = x;
        while (temp > 0) {
            rem = temp % 10;  // extract off the rightmost digit
            sum = (sum * 10) + rem; // push it left
            temp = temp / 10; // remove the rightmost digit
        }
        return x == sum;
    }
}
