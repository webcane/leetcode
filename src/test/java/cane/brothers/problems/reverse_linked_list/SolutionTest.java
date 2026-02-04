package cane.brothers.problems.reverse_linked_list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Constraints:
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 */
class SolutionTest {

    Solution sol;

    @BeforeEach
    void setUp() {
        sol = new Solution();
    }

    @Test
    void test_reverseList_1() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode result = sol.reverseList(head);

        assertEquals(5, result.val);
        assertEquals(4, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(1, result.next.next.next.next.val);
    }

    @Test
    void test_reverseList_2() {
        ListNode head = new ListNode(1, new ListNode(2));

        ListNode result = sol.reverseList(head);

        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
    }

    @Test
    void test_reverseList_3() {
        ListNode result = sol.reverseList(null);
        assertNull(result);
    }
}