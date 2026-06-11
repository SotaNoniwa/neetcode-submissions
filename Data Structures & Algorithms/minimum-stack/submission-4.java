
// Implementation with LinkedList
class MinStack {
    LinkedList<Integer> list;
    LinkedList<Integer> minList;

    public MinStack() {
        list = new LinkedList<>();
        minList = new LinkedList<>();
    }

    public void push(int val) {
        list.addFirst(val);

        if (minList.isEmpty() || val < minList.peek()) {
            minList.addFirst(val);
        } else {
            minList.addFirst(minList.peek());
        }
    }

    public void pop() {
        list.poll();
        minList.poll();
    }

    public int top() {
        return list.peek();
    }

    public int getMin() {
        return minList.peek();
    }
}