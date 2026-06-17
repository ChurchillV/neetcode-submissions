class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }

        System.out.println("Minstack top: " + minStack.peek());
    }
    
    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        int top = stack.peek();

        if(top == minStack.peek()) {
            minStack.pop();
        }

        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
