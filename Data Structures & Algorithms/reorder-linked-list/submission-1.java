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
    public ListNode reverseListAlt(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return previous;
    }

    public void reorderList(ListNode head) {
        ListNode start = head;
        ListNode fast = start;
        ListNode slow = start;

        while (fast != null && fast.next!= null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = reverseListAlt(slow.next);
        slow.next = null;

        while(secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }
}
