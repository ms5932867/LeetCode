/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> dep = new Stack<>();
        TreeNode p = root;
        int d = 1, res = 0;
        while (!st.isEmpty() || p != null) {
            if (p != null) {
                res = Math.max(res, d);
                st.push(p);
                dep.push(d);
                p = p.left;
                d++;
            } else {
                p = st.pop().right;
                d = dep.pop() + 1;
            }
        }
        return res;
    }
}
