/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */



public class Solution {
    public static int getDifference(ListNode A, ListNode B) {
        int lenA = 0;
        int lenB = 0;
        while(A!=null) {lenA++;A = A.next;}
        while(B!=null) {lenB++;B = B.next;}

        return lenA-lenB;
}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int diff = getDifference(headA,headB);
        if (diff > 0){
            while(diff--!=0){
                headA = headA.next;
            }
        }
        else {
            while(diff++!=0){
                headB = headB.next;
            }
        }

        while(headA!=null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}

/**
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet hs = new HashSet();
        while(headA != null) {
            hs.add(headA);
            headA = headA.next;
        }

        while(headB != null) {
            if (hs.contains(headB)){
                 return headB;
            }
            headB = headB.next;
        }

        return null;
    }
} */