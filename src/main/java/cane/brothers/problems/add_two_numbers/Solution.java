package cane.brothers.problems.add_two_numbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // TODO validate input
        return useWhile(l1, l2);
    }

    // сложения двух чисел, представленных в виде связанных списков,
    // где каждый узел содержит одну цифру, а цифры записаны в обратном порядке (единицы в начале).
    private ListNode useWhile(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cursor = result;
        int carry = 0;

        // Проходит по обоим спискам одновременно,
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = getNodeValue(l1);
            int l2Val = getNodeValue(l2);

            // складывая соответствующие цифры и учитывая (carry).
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            int currVal = sum % 10;

            // текущее значение записываем в новый узел результирующего списка.
            cursor.next = new ListNode(currVal);
            // обновляем курсор
            cursor = cursor.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        // возвращаем результат отсекая ведущий 0
        return result.next;

    }

    protected int getNodeValue(ListNode node) {
        // Use value as 0 from the list that ended shorter than the other.
        return node != null ? node.val : 0;
    }
}
