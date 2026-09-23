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

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(ListNode listNode: lists){
            ListNode currEl = listNode;
            while(currEl != null){
                pq.offer(currEl.val);
                currEl = currEl.next;
            }
        }

        while(!pq.isEmpty()){
            ListNode next = new ListNode(pq.poll(), null);
            curr.next = next;
            curr = next;
        }

        return dummy.next;
    }
}
