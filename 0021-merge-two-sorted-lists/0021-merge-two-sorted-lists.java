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
ListNode head=new ListNode(-1);
        ListNode previous=head;
        while(list1!=null && list2!=null) {
            if(list1.val<=list2.val) {
                previous.next=list1;
                list1=list1.next;
            } else {
                previous.next=list2;
                list2=list2.next;
            }
            previous=previous.next;
        }
        while(list1!=null) {
            previous.next=list1;
            list1=list1.next;
            previous=previous.next;
        }
        while(list2!=null) {
            previous.next=list2;
            list2=list2.next;
            previous=previous.next;
        }
        return head.next;
    }
}