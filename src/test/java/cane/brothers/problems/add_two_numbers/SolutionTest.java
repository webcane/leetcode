package cane.brothers.problems.add_two_numbers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void addTwoNumbers() {
    ListNode node1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));

    Solution sol = new Solution();
    ListNode result = sol.addTwoNumbers(node1, node2);

    assertEquals(7, result.val);
    assertEquals(0, result.next.val);
    assertEquals(8, result.next.next.val);
  }
}