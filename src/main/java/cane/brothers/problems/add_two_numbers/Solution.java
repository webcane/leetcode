package cane.brothers.problems.add_two_numbers;

public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode();
    ListNode head = result;

    int carry = 0;

    while (l1 != null || l2 != null) {
      int l1Val = getNodeValue(l1);
      int l2Val = getNodeValue(l2);

      int sum = l1Val + l2Val + carry;

      carry = sum >= 10 ? 1 : 0;
      sum = sum % 10;

      result.next = new ListNode(sum);
      result = result.next;

      l1 = getNodeNext(l1);
      l2 = getNodeNext(l2);
    }

    if (carry != 0) {
      result.next = new ListNode(carry);
    }

    return head.next;
  }

  protected int getNodeValue(ListNode node) {
    // Use value as 0 from the list that ended shorter than the other.
    return node != null ? node.val : 0;
  }

  protected ListNode getNodeNext(ListNode node) {
    return node != null ? node.next : null;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
