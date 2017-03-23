/** 23	Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // idea : D&C
        return mergeKLists(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeKLists(ListNode[] lists, int s, int e){
        if(s > e) return null;
        if(s == e) return lists[s];
        
        int m = s + (e - s)/2;
        ListNode l1 = mergeKLists(lists, s, m),
                 l2 = mergeKLists(lists, m + 1, e);
        return merge2Lists(l1, l2);
    }
    
    private ListNode merge2Lists(ListNode p, ListNode q){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(p != null || q != null){
            if(p == null) { curr.next = q; break; }
            if(q == null) { curr.next = p; break; }
            if(q.val < p.val){
                curr.next = q;
                q = q.next;
                curr = curr.next;
            }
            else{
                curr.next = p;
                p = p.next;
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}