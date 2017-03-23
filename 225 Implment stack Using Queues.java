class MyStack {
    private Queue<Integer> queue = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        int n = queue.size();
        queue.add(x);
        for(int i = 0; i < n; i++){
            queue.add(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}