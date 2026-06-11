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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prior = head;
        ListNode later = dummy;

        // Make fixed space between prior and later, that is, there are n nodes between them.
        for (int i = 0; i < n; i++) {
            prior = prior.next;
        }

        // After this while loop, later.next is the node we want to delete
        while (prior != null) {
            prior = prior.next;
            later = later.next;
        }
        
        // Delete the node by updating reference
        later.next = later.next.next;

        return dummy.next;
    }
}
