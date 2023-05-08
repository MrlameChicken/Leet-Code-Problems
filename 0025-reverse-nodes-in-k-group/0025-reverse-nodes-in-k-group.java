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
    public ListNode reverseKGroup(ListNode head, int k) {
       int length = length(head);
       ListNode dummyHead = new ListNode(0);
       dummyHead.next = head;
    
       ListNode previous = dummyHead;
       ListNode current;
       ListNode next;
       while(length >= k) {
           current = previous.next;
           next = current.next;
           for (int i=1;i<k;i++) {
               current.next = next.next;
               next.next = previous.next;
                previous.next = next;
                next = current.next;
           }
           previous = current;
           length = length - k;
       }
        return  dummyHead.next;
    }
    
    public int length(ListNode head) {
        ListNode current = head;
        int length = 0;
        while(current!=null) {
            current = current.next;
            length++;
        }
        return length;
    }
}