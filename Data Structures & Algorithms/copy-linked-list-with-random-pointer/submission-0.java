/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // <original node, copied node>
        Map<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);

        // Copy and store nodes without pointers (next and random)
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            oldToCopy.put(current, copy);
            current = current.next;
        }

        // Copy pointers
        current = head;
        while (current != null) {
            Node copy = oldToCopy.get(current);
            copy.next = oldToCopy.get(current.next);
            copy.random = oldToCopy.get(current.random);
            current = current.next;
        }

        return oldToCopy.get(head);
    }
}
