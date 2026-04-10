/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int d1 = (l1 == null) ? 0 : l1.val;
            int d2 = (l2 == null) ? 0 : l2.val;

            int sum = (d1 + d2 + carry);

            current.next = new ListNode(sum % 10);
            carry = sum / 10;

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;

            current = current.next;
        }

        return result.next;
    }
}
