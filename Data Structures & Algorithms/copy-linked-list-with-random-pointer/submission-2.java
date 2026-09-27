/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> clonesMap = new HashMap<Node, Node>();

        Node current = head;
        while(current != null){
            clonesMap.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;

        while(current != null){
            var newCurrent = clonesMap.get(current);
            if(current.next !=null){
                newCurrent.next = clonesMap.get(current.next);
            }

            if(current.random != null){
                newCurrent.random = clonesMap.get(current.random);
            }

            current = current.next;
        }

        return clonesMap.get(head);
    }
}
