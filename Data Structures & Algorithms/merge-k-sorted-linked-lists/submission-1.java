/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1, null);
        ListNode curr = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            Comparator.comparingInt(node -> node.val)
        );

        for(ListNode listNode: lists){
            if(listNode != null){
                pq.offer(listNode);
            }
        }

        while(!pq.isEmpty()){
            ListNode popped = pq.poll();
            
            ListNode next = new ListNode(popped.val, null);
            curr.next = next;
            curr = next;

            if(popped.next != null){
                pq.offer(popped.next);
            }
        }

        return dummy.next;
    }
}
