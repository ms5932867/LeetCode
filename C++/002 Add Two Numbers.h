/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        ListNode preHead(0), *tail = &preHead;
        int carry = 0;
        while(l1 != NULL || l2 != NULL){
            if(l1 != NULL){ carry += l1->val; l1 = l1->next;}
            if(l2 != NULL){ carry += l2->val; l2 = l2->next;}
            tail->next = new ListNode(carry % 10);
            tail = tail->next;
            carry = carry > 9 ? 1 : 0;
        }
        if (carry > 0){ tail->next = new ListNode(carry);}
        return preHead.next;
        
    }
};