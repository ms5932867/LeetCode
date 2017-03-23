/* 103	Binary Tree Zigzag Level Order Traversal
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        int level = 1;
        if(root != null)deque.addLast(root);
        while(!deque.isEmpty()){
            int n = deque.size();
            List<Integer> currInt = new LinkedList<>();
            Deque<TreeNode> nextLevel = new LinkedList<>();
            
            for(int i = 0; i < n; i++){
                if(level % 2 == 0){ // even level, child from right to left
                    TreeNode cur = deque.pollLast();
                    currInt.add(cur.val);
                    if(cur.right != null) nextLevel.addFirst(cur.right);
                    if(cur.left != null) nextLevel.addFirst(cur.left);
                }
                else{
                    TreeNode cur = deque.pollFirst();
                    currInt.add(cur.val);
                    if(cur.left != null) nextLevel.addLast(cur.left);
                    if(cur.right != null) nextLevel.addLast(cur.right);
                }
            }
            res.add(currInt);
            deque = nextLevel;
            level++;
        }
        return res;
    }
}