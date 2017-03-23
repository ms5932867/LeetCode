/* 232. Implement Queue using Stacks
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top,
 size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using 
a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called 
on an empty queue).
*/
class MyQueue {
    private Stack<Integer> sf = new Stack<>();
    private Stack<Integer> sb = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        while(!sb.isEmpty()) sf.push(sb.pop());
        sf.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!sb.isEmpty()){
            sb.pop();
            return;
        }
        shift();
        sb.pop();
    }

    // Get the front element.
    public int peek() {
        if(!sb.isEmpty()) return sb.peek();
        shift();
        return sb.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return sf.isEmpty() && sb.isEmpty();
    }
    
    private void shift(){
        // shift all element from sf to sb
        while(!sf.isEmpty())
            sb.push(sf.pop());
    }
}