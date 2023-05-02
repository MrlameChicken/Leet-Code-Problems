/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
        
        if (head == null) {
            return false;
        }
        
        while(fast.next != null && fast.next.next != null) {
            
            slow = slow.next; 
            fast = fast.next.next;   
            if (slow == fast) {
                return true;
            }
        }
        
        // this is just some bs
         System.gc();
        return false;
    }
}

   /** public boolean hasCycle(ListNode head) {
        HashSet hs = new HashSet();
        while(head!=null) {
            if (hs.contains(head)) {
                return true;
            }
            hs.add(head);
            head = head.next;
        }
        return false;
    }**/