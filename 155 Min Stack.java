/* 155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

public class MinStack {
    // idea: store current min value,
    // if new ele is smaller than current min, push current min into stack before push the new ele
    // after pop, if peek ele equals current min, pop again
    int _min = Integer.MAX_VALUE;
    Stack<Integer> _stack = new Stack<Integer>();
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(x <= _min){
            _stack.push(_min);
            _min = x;
        }
        _stack.push(x);
    }
    
    public void pop() {
        if(_stack.peek() == _min){
            _stack.pop();
            _min = _stack.peek();
        }
        _stack.pop();
    }
    
    public int top() {
        return _stack.peek();
    }
    
    public int getMin() {
        return _min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */