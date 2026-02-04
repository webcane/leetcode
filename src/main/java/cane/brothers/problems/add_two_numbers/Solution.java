package cane.brothers.problems.add_two_numbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return useWhile(l1, l2);
    }

    private ListNode useWhile(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cursor = result;
        int carry = 0;

        ListNode ln1 = l1, ln2 = l2;
        while (ln1 != null || ln2 != null || carry != 0) {
            int l1Val = getNodeValue(ln1);
            int l2Val = getNodeValue(ln2);

            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            int currVal = sum % 10;
            cursor.next = new ListNode(currVal);
            cursor = cursor.next;

            if (ln1 != null)
                ln1 = ln1.next;
            if (ln2 != null)
                ln2 = ln2.next;
        }

        return result.next;

    }

    protected int getNodeValue(ListNode node) {
        // Use value as 0 from the list that ended shorter than the other.
        return node != null ? node.val : 0;
    }
}
