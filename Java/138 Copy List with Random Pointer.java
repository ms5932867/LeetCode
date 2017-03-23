/** 138	Copy List with Random Pointer
 * A linked list is given such that each node contains an 
 * additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)return null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode res = new RandomListNode(0);
        RandomListNode h1 = res;
        RandomListNode p1 = head;
        while(p1 != null){
            h1.next = new RandomListNode(p1.label);
            map.put(p1,h1.next);
            p1 = p1.next;
            h1 = h1.next;
        }
        RandomListNode h2 = res.next;
        RandomListNode p2 = head;
        while(p2 != null){
            h2.random = map.get(p2.random);
            h2 = h2.next;
            p2 = p2.next;
        }
        return res.next;
    }
}