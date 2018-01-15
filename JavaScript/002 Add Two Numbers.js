/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    var dummyHead = new ListNode(0);
    var tail = dummyHead;
    var carry = 0;
    while(l1 !== null || l2 !== null){
        if(l1 !== null){carry += l1.val; l1 = l1.next;}
        if(l2 !== null){carry += l2.val; l2 = l2.next;}
        tail.next = new ListNode(carry % 10);
        tail = tail.next;
        carry = (carry > 9 ? 1 : 0);
    }
    if(carry) tail.next = new ListNode(carry);
    return dummyHead.next;
    
};