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
//     public ListNode detectCycle(ListNode head) {
//         HashSet<ListNode> set = new HashSet<ListNode>();
//         while (head != null) {
//             // If we have already has this node
//             // in hashmap it means their is a cycle
//             // (Because you we encountering the
//             // node second time).
//             if (set.contains(head))
//                 return head;
 
//             // If we are seeing the node for
//             // the first time, insert it in hash
//             set.add(head);
 
//             head = head.next;
//         }
 
//         return null;
//     }
     public ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                slow=head;

                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}