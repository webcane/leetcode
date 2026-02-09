package cane.brothers.problems.valid_parenthese;

import java.util.ArrayDeque;
import java.util.Map;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class Solution {
    public boolean isValid(String s) {
        validateInput(s);
        var bracketsMap = Map.of(')', '(', '}', '{', ']', '[');
        var stack = new ArrayDeque<Character>();

        for (char c : s.toCharArray()) {
            if (bracketsMap.containsKey(c)) {
                var top = stack.pollFirst();
                if (top == null || top != bracketsMap.get(c)) {
                    return false;
                }
            } else {
                // push
                stack.addFirst(c);
            }
        }
        return stack.isEmpty();
    }

    private void validateInput(String s) {
// Constraints:
//
//1 <= s.length <= 104
//s consists of parentheses only '()[]{}'.
    }
}
