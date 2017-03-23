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
    private int _count = 0, _ans;
    public int kthSmallest(TreeNode root, int k) {
        // idea : inorder traversal of BST, k count down
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode p = stack.pop();
                k--;
                if(k == 0) return p.val;
                curr = p.right;
            }
        }
        return -1;
    }
}