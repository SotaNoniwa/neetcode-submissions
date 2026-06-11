class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        this.stack.push(val);

        if (this.minStack.isEmpty() || val < this.minStack.peek()) {
            this.minStack.push(val);
        } else {
            // copy minimum value in minStack and push it to itself
            this.minStack.push(this.minStack.peek());
        }
    }

    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.minStack.peek();
    }
}