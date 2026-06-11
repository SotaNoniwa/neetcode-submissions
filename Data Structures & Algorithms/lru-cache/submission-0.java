class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private Map<Integer, Node> cache;
    private int capacity;
    private Node first;
    private Node last;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.first = new Node(0, 0);
        this.last = new Node(0, 0);
        this.first.next = this.last;
        this.last.prev = this.first;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > this.capacity) {
            Node LRU = this.first.next;
            remove(LRU);
            cache.remove(LRU.key);
        }
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = this.last.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.last;
        this.last.prev = node;
    }
}