/** 24	Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, 
 * only nodes itself can be changed.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while(curr.next != null && curr.next.next != null){
            ListNode p1 = curr.next,
                     p2 = p1.next;
            p1.next = p2.next;
            p2.next = p1;
            curr.next = p2;
            curr = p1;
        }
        return dummy.next;
    }
}