/** 234. Palindrome Linked List
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head, p2 = head;
        // find mid
        while(p2!= null && p2.next != null){
            p2 = p2.next;
            if(p2.next != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
        }
        // reverse second half
        ListNode mid = p1, tail = p2;
        if(mid == null) return true;
        p2 = mid.next;
        while(p2 != null){
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        // compare each pair
        p2 = tail;
        mid.next = null;
        p1 = head;
        while(p1 != null && p2 != null && p1 != p2){
            if(p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}