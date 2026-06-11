class Node {
    // Doubly LinkedList
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    // LRU = Least Recently Used, MRU = Most Recently Used
    Map<Integer, Node> cache;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0); // head.next -> LRU
        tail = new Node(0, 0); // tail.prev -> MRU
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        insert(node);
        return node.val;
    }

    public void put(int key, int value) {
        // Remove from doubly LinkedList
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        // Update cache
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);

        if (cache.size() > capacity) {
            Node LRU = head.next;
            remove(LRU);
            cache.remove(LRU.key);
        }
    }

    private void insert(Node node) {
        Node oldMRU = tail.prev;
        tail.prev = node;
        node.next = tail;
        oldMRU.next = node;
        node.prev = oldMRU;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}