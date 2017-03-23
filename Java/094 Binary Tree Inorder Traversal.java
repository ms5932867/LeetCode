/** 94	Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode p = stack.pop();
                res.add(p.val);
                curr = p.right;
            }
        }
        return res;
    }
}