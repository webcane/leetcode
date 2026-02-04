package cane.brothers.problems.merge_k_sorted_lists;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 *
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {

    //    public LinkedList<Integer> mergeKLists(LinkedList<Integer>[] lists) {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        result.val = lists[0].val;
        for (ListNode node : lists) {
//            do {
//                // TODO
//            } while(node.next != null);
            result.val = node.val;
        }

        return result;
    }
}
