class LRUCache {
    private int capacity;
    private int size;
    private CacheNode head;
    private CacheNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new CacheNode(-1, -1 , null, null);
        this.tail = new CacheNode(-1, -1 ,this.head, null);
        this.head.next = this.tail;
    }

    public int get(int key) {
        // Iterate over list, then append to the first element
        CacheNode current = findNodeWithKey(key);

        if (current == null) {
            return -1;
        }

        moveUsedValueToHead(current);

        return current.value;
    }

    public void put(int key, int value) {
        // verify size, if size > capacity, evict tail
        CacheNode toUpsert = findNodeWithKey(key);
        if (toUpsert == null) {
            CacheNode currentHead = this.head.next;

            toUpsert = new CacheNode(key, value, this.head, currentHead);
            this.head.next = toUpsert;
            currentHead.prev = toUpsert;
            size++;
        } else {
            toUpsert.value = value;
            moveUsedValueToHead(toUpsert);
        }

        // if size > capacity, pop the tail
        removeExpiredEntries();
    }

    private CacheNode findNodeWithKey(int key) {
        CacheNode current = head.next;
        while (current != null && current.key != key) {
            if(current == tail) return null;

            current = current.next;
        }
        return current;
    }

    private void moveUsedValueToHead(CacheNode newHead) {
        if (newHead == head.next) {
            return;
        }

        CacheNode currentHead = this.head.next;
        // swap pointers from previous values of current head
        newHead.prev.next = newHead.next;
        newHead.next.prev = newHead.prev;

        // swap pointers from head
        currentHead.prev = newHead;
        this.head.next = newHead;

        newHead.prev = this.head;
        newHead.next = currentHead;
    }

    private void removeExpiredEntries() {
        while (size > capacity && size > 0) {
            CacheNode currentTail = this.tail.prev;
            currentTail.prev.next = this.tail;
            this.tail.prev = currentTail.prev;

            size--;
        }
    }

    class CacheNode {
        int key;
        int value;
        CacheNode prev;
        CacheNode next;

        CacheNode(int key, int value, CacheNode prev, CacheNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
