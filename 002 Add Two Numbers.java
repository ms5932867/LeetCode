/** 2	Add Two Numbers
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, prevNode = dummyHead;
        int carry = 0;
        while(p1 != null || p2 != null){
            int v1 = (p1 == null) ? 0 : p1.val,
                v2 = (p2 == null) ? 0 : p2.val,
                curr = v1 + v2 + carry;
            carry = curr / 10;
            prevNode.next = new ListNode(curr % 10);
            prevNode = prevNode.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if(carry > 0){
            prevNode.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}