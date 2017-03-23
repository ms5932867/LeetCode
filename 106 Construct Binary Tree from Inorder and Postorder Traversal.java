/* 106	Construct Binary Tree from Inorder and Postorder Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0) return null;
        return buildTree(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int[] postorder, int posS, int posE, int inS, int inE)
	{
        if(posS > posE || inS > inE) return null;
        
        int rootV = postorder[posE];
        TreeNode root = new TreeNode(rootV);
        
        int inorderRoot = -1;
        for(int i = inS; i <= inE; i++){
            if(inorder[i] == rootV){
                inorderRoot = i;
                break;
            }
        }
        
        int leftLen = inorderRoot - inS;
        root.left  = buildTree(inorder, postorder, posS, posS + leftLen - 1, inS, inorderRoot - 1);
        root.right = buildTree(inorder, postorder, posS + leftLen, posE - 1, inorderRoot + 1, inE);
        return root;
    }
}