class MyLinkedList {
    private Node head;
    private Node tail;

    private int size;

    public MyLinkedList() {
        this.head = new Node(-1, null ,null);
        this.tail = new Node(-1, this.head, null);
        this.head.next = this.tail;
    }

    public int get(int index) {
        if(index >= size || index < 0) return -1;

        Node current = getNodeAtIndex(index);

        return current.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) index = 0;
        if (index > size) return;

        Node currentNode = getNodeAtIndex(index);
        Node previous = currentNode.prev;

        Node newNode = new Node(val, previous , currentNode);

        previous.next = newNode;
        currentNode.prev = newNode;
        
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if(index >= size || index < 0) return;

        Node toDelete = getNodeAtIndex(index);

        toDelete.prev.next = toDelete.next;
        toDelete.next.prev = toDelete.prev;

        this.size--;
    }

    private Node getNodeAtIndex(int index){
        Node current = this.head.next;
        int count = 0;
        while(count < index){
            count++;
            current = current.next;
        }
        return current;
    }


    class Node {
        int val;
        Node next;
        Node prev;

        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
