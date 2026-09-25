class MyLinkedList {
    private Node head;
    private Node tail;

    private int size;

    public MyLinkedList() {
        this.head = new Node(-1, null);
        this.tail = head.next;
        this.size = 0;
    }

    public int get(int index) {
        if(index >= size || index < 0) return -1;

        Node current = getNodeBeforeIndex(index);

        return current.next.val;
    }

    public void addAtHead(int val) {
        Node currentHead = this.head.next;
        Node newHead = new Node(val, currentHead);

        this.head.next = newHead;
        if(size == 0){
            tail = newHead;
        }


        this.size++;
    }

    public void addAtTail(int val) {
        Node currentTail = this.tail;
        
        currentTail.next = new Node(val, null);
        this.tail = currentTail.next;

        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) index = 0;
        if (index > size) return;

        Node before = getNodeBeforeIndex(index);
        Node currentNode = before.next;
        Node newNode = new Node(val, currentNode);
        before.next = newNode;

        if(newNode.next == null){
            tail = newNode;
        }
        
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if(index >= size || index < 0) return;

        Node before = getNodeBeforeIndex(index);
        Node toDelete = before.next;
        before.next = toDelete.next;

        if(toDelete == tail){
            tail = before;
        }

        this.size--;
    }

    private Node getNodeBeforeIndex(int index){
        Node current = this.head;
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

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
