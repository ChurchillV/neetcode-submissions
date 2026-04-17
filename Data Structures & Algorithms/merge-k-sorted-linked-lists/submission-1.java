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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        int size = lists.length;


        while(!containsAllNullNodes(lists)) {
            int minIdx = -1;

            for(int n = 0; n < size; n++) {
                if(lists[n] != null) {
                    if(minIdx == -1 || lists[n].val < lists[minIdx].val) {
                        minIdx = n;
                    }
                }
            }

            currentNode.next = lists[minIdx];
            currentNode = currentNode.next;
            lists[minIdx] = lists[minIdx].next;
        }

        return result.next;
    }

    public boolean containsAllNullNodes(ListNode[] lists) {
        int size = lists.length;
        for(int i = 0; i < size; i++) {
            if(lists[i] != null) {
                return false;
            }
        }

        return true;
    }
}
