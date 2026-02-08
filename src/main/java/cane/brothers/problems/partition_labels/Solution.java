package cane.brothers.problems.partition_labels;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears
 * in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such
 * as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 * Return a list of integers representing the size of these parts.
 * Constraints:
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 * Topics:
 * - Hash Table
 * - Two Pointers
 * - String
 * - Greedy
 */
public class Solution {

    public List<Integer> partitionLabels(String s) {
        validateInput(s);
        return classic(s);
    }

    /**
     * Для каждой буквы нужно знать её последнее вхождение в строку. Тогда мы можем "расширять" текущий сегмент
     * до тех пор, пока не достигнем последнего вхождения всех букв, находящихся в этом сегменте.
     */
    private List<Integer> classic(String s) {
        var result = new ArrayList<Integer>();
        // TODO
        return result;
    }

    private void validateInput(String s) {
        if (s == null) {
            throw new NullPointerException("s should be given");
        }

        //
    }
}
