class MyLinkedList {
    private Node head;
    private int size;

    public MyLinkedList() {
        this.head = new Node(-1, null);
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
        this.size++;
    }

    public void addAtTail(int val) {
        Node before = getNodeBeforeIndex(size);
        before.next = new Node(val, null);

        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) index = 0;
        if (index > size) return;

        Node before = getNodeBeforeIndex(index);
        Node currentNode = before.next;
        Node newNode = new Node(val, currentNode);
        before.next = newNode;
        
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if(index >= size || index < 0) return;

        Node before = getNodeBeforeIndex(index);
        Node toDelete = before.next;

        if(toDelete != null){
            before.next = toDelete.next;
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
