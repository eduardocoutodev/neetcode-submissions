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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Invert list
        // count n
        ListNode curr = head;
        int size = 0;
        while(curr != null){
            size++;
            curr = curr.next;
        }

        ListNode mock = new ListNode(0, head);
        ListNode prev = mock;
        curr = mock.next;
        int index = 0;
        
        while(curr != null){
            ListNode next = curr.next;

            if(size - n == index){
                // remove
                prev.next = curr.next;
                break;
            }

            prev = curr;
            curr = next;    

            index++;
        }

        return mock.next;
    }
}
