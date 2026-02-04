package cane.brothers.problems.add_two_numbers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void test_addTwoNumbers_1() {
    ListNode node1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));

    Solution sol = new Solution();
    ListNode result = sol.addTwoNumbers(node1, node2);

    assertEquals(7, result.val);
    assertEquals(0, result.next.val);
    assertEquals(8, result.next.next.val);
  }

    @Test
    void test_addTwoNumbers_2() {
        ListNode node1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode node2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        Solution sol = new Solution();
        ListNode result = sol.addTwoNumbers(node1, node2);

        assertEquals(8, result.val);
        assertEquals(9, result.next.val);
        assertEquals(9, result.next.next.val);
        assertEquals(9, result.next.next.next.val);
        assertEquals(0, result.next.next.next.next.val);
        assertEquals(0, result.next.next.next.next.next.val);
        assertEquals(0, result.next.next.next.next.next.next.val);
        assertEquals(1, result.next.next.next.next.next.next.next.val);
    }
}