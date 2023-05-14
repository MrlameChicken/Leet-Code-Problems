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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null||head.next == null) return head;
        int length = length(head);
        ListNode temp = head;
       // System.out.println(length);
        for (int i=0;i<length;i = i+1) { 
           // System.out.println(i);
            if (i+1 == length) {
               // System.out.println(temp.val);
                temp.next = head;
                break;
            }
            temp = temp.next;
        }
        
        ListNode res = head;
        ListNode ans = null;
        k = k%length;
        for (int j=0;j<length-k;j++) { 
            if (j+1 == length-k) {
                ans = res.next;
                res.next = null;
                break;
            }
            res = res.next;
        }
        return ans;
    }
    
    public static int length(ListNode head) {
        ListNode current = head;
        int length = 0;
        while(head!=null) {
            length++;
            head = head.next;
        }
        return length;
    }
}