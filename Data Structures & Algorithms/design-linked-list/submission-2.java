class MyLinkedList {
    List<Integer> nodes;

    public MyLinkedList() {
        this.nodes = new ArrayList<Integer>();
    }
    
    public int get(int index) {
        if(index >= this.nodes.size()) return -1;

        return this.nodes.get(index);
    }
    
    public void addAtHead(int val) {
        this.nodes.add(0, val);
    }
    
    public void addAtTail(int val) {
        this.nodes.add(val);
    }
    
    public void addAtIndex(int index, int val) {
        this.nodes.add(index,val);
    }
    
    public void deleteAtIndex(int index) {
        if(index >= this.nodes.size()) return;

        this.nodes.remove(index);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */