/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        //return criteria: head.next is null. when reaching the right end of the linked list
        //or the linked list is null, which is head == null
        if (head.next == null|| head == null) return head;
        //traverse
        ListNode p = reverseList(head.next);
        //reverse the curr.next.next to curr and set curr.next to null
        head.next.next = head;
        head.next = null;
        return p;
         
     }
}