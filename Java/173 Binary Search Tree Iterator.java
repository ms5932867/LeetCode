/* 173. Binary Search Tree Iterator
Implement an iterator over a binary search tree (BST). 
Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory,
where h is the height of the tree.
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode curr;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        curr = root;
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curr != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p = stack.pop();
        curr = p.right;
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        return p.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */