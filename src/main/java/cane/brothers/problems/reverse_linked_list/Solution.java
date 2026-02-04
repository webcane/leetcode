package cane.brothers.problems.reverse_linked_list;

public class Solution {

    public ListNode reverseList(ListNode head) {
        return useWhile(head);
    }

    private ListNode useWhile(ListNode head) {
        ListNode result = null;

        ListNode ln = head;
        while (ln != null) {
            int lnVal = getNodeValue(ln);
            result = new ListNode(lnVal, result);
            ln = ln.next;
        }

        return result;
    }

    protected int getNodeValue(ListNode node) {
        return node != null ? node.val : 0;
    }
}
