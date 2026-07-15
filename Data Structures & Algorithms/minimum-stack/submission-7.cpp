class MinStack {
   private:
    stack<int> min_stack;
    stack<int> normal_stack;

   public:
    MinStack() {}

    void push(int val) {
        if (min_stack.empty()) {
            min_stack.push(val);
        } else {
            min_stack.push(min(val, min_stack.top()));
        }
        normal_stack.push(val);
    }

    void pop() {
        min_stack.pop();
        normal_stack.pop();
    }

    int top() { return normal_stack.top(); }

    int getMin() { return min_stack.top(); }
};
