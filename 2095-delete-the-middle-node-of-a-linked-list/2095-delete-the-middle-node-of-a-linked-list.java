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
    public ListNode deleteMiddle(ListNode head) {
        ListNode currentNode = head;
        ListNode prev = null;
        //if single elemnet in list
        if (currentNode.next == null) {
            currentNode = null;
            return currentNode;
        }
        
        //find middle
        ListNode middle = middleNode(head);
        
        while (currentNode != null && currentNode != middle) {
           prev = currentNode;
           currentNode = currentNode.next;
        }
        
        if (currentNode!= null) {
            prev.next = currentNode.next;
        }
        
        return head;
    }
    
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast !=null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}