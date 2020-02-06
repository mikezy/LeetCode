/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      if(head == null) return head;
      //hashmap <index, node>
      
      HashMap<Integer, ListNode> map = new HashMap<>();
      
      //traverse the entire list
      int index = 1;
      ListNode curr = head; 
      while (curr != null) {
        map.put(index, curr);
        curr = curr.next;
        index++;
        
      }
      index--;
      //remove head when n == index
      if(n == index) {
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
      }
      //remove the index +1 -n elem
      curr = map.get(index-n);
      curr.next = curr.next.next;
      return head;
    }
}