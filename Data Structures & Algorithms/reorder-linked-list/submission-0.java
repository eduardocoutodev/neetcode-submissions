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
    public void reorderList(ListNode head) {
        // 1. Find mid
        // 1 -> 2 -> 3 -> 4 -> 5
        // mid = 3
        ListNode mid = findMidOfList(head);
        // 4 -> 5
        ListNode secondHalfMid = mid.next;

        // Need to split into two lists to avoid merging incorrectly
        // head = 1 -> 2 -> 3 // secondHalf = 4 -> 5
        mid.next = null;
        
        ListNode reversedSecondHalfMid = reverseLinkedList(secondHalfMid);

        // reversedSecondHalf = 5 -> 4

        // 3. Merge head and reversedSecondHalfMid
        ListNode firstHalf = head;
        while (reversedSecondHalfMid != null){
            ListNode tmp1 = firstHalf.next;
            ListNode tmp2 = reversedSecondHalfMid.next;

            firstHalf.next = reversedSecondHalfMid;
            reversedSecondHalfMid.next = tmp1;
            
            firstHalf = tmp1;
            reversedSecondHalfMid = tmp2;

        }
        
    }

    private ListNode findMidOfList(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
