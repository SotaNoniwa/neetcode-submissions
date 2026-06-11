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
    // O(n) run time solution
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;

        // Identify the middle node (separation point)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head; // first partition
        ListNode second = reverse(slow.next); // reordered second partition
        slow.next = null; // Disconnect two partitions

        while (second != null && first != null) {
            // Store nodes in other location before modification
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            // Reorder nodes
            first.next = second;
            second.next = firstNext;

            // Moving to the next nodes
            first = firstNext;
            second = secondNext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next;
        ListNode curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}