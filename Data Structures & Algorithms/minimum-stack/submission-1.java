class MinStack {
    private record MinStackNode(
        int value,
        int minValueSoFar,
        MinStackNode next
    ){}

    private MinStackNode head;

    public MinStack() {
    }
    
    public void push(int val) {
        var currentHead = this.head;
        if(currentHead == null){
            this.head = new MinStackNode(val, val, null);
            return;
        }
        
        this.head = new MinStackNode(val, Math.min(currentHead.minValueSoFar, val), currentHead);
    }
    
    public void pop() {
        var currentHead = this.head;
        this.head = currentHead.next;
        currentHead = null;
    }
    
    public int top() {
        return this.head.value;
    }
    
    public int getMin() {
        return this.head.minValueSoFar;
    }
}
