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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode(0);
        ListNode curr = root;

        while(list1 != null && list2 != null){
            ListNode toAdd = null;

            if(list1.val < list2.val){
                toAdd = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                toAdd = new ListNode(list2.val);
                list2 = list2.next;
            }

            curr.next = toAdd;
            curr = toAdd;
        }

        while(list1 != null){
            ListNode toAdd = new ListNode(list1.val);
            curr.next = toAdd;
            
            curr = toAdd;
            list1 = list1.next;
        }

        while(list2 != null){
            ListNode toAdd = new ListNode(list2.val);
            curr.next = toAdd;

            curr = toAdd;
            list2 = list2.next;
        }

        return root.next;
    }
}