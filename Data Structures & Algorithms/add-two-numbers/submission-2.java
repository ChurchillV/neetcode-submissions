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

// Recursive solution
class Solution {
    ListNode result = new ListNode();
    ListNode current = result;

    public void add(ListNode l1, ListNode l2, int carry) {

        if(l1 == null && l2 == null && carry == 0) return;

        int v1 = (l1 == null) ? 0 : l1.val;
        int v2 = (l2 == null) ? 0 : l2.val;

        int sum = v1 + v2 + carry;

        current.next = new ListNode(sum % 10);
        current = current.next;
        carry = sum / 10;

        l1 = (l1 == null) ? null : l1.next;
        l2 = (l2 == null) ? null : l2.next;

        add(l1, l2, carry);
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        add(l1, l2, 0);
        return result.next;
    }
}
