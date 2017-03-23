/** 	21	Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead, p1 = l1, p2 = l2;
        while(p1 != null || p2 != null){
            if(p1 == null || (p2 != null && p1.val > p2.val)) { p.next = p2; p2 = p2.next;}
            else { p.next = p1; p1 = p1.next;}
            p = p.next;
        }
        return dummyHead.next;
    }
}