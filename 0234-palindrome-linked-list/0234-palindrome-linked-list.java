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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        slow = reverse(slow.next);
        //slow = slow;
        ListNode dummy = head;
        
        while(slow!=null) {
            if(dummy.val != slow.val) return false;
            slow = slow.next;
            dummy = dummy.next;
        }
        
        return true;
    }
    
     public static ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode next = null;
        while(head !=null){
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        } 
         return previous;
     }
}