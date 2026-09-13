class MinStack {
    Deque<Integer> s1;
    Deque<Integer> s2;

    public MinStack() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }
    
    public void push(int val) {
        s1.push(val);
        
        if (!s2.isEmpty() && s2.peek() < val) {
            s2.push(s2.peek());
        } else {
            s2.push(val);
        }
    }
    
    public void pop() {
        s1.pop();
        s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}
