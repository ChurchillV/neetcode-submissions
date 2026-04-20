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

// Solution using a min head / priority queue
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a,b) -> a.val - b.val); // Ascending order

        for(ListNode list : lists) {
            if(list != null) {
                heap.add(list);
            }
        }

        ListNode result = new ListNode(0);
        ListNode current = result;

        while(!heap.isEmpty()) {
            ListNode node = heap.poll();
            current.next = node;
            current = current.next;

            node = node.next;
            if(node != null) {
                heap.add(node);
            } 
        }

        return result.next;
    }
}
