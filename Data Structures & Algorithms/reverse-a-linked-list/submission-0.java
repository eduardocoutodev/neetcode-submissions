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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        // Input: head = [0,1,2,3]

        //Output: [3,2,1,0]

        ListNode prev = null; // 
        ListNode curr = head; // 

        while(curr != null){
            // need to save to a temp variable
            var tmp = curr.next;
            
            // inverse to point in other direction
            curr.next = prev;

            // move pointer forward, both prev and curr
            prev = curr;
            curr = tmp;
        }

        return prev;        
    }
}
