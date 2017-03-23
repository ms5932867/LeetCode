/** 199. Binary Tree Right Side View
Given a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //********************************** BFS *************************************//
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // idea: ouput the last element of each BFS level
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        
        if(root != null) queue.add(root);
        
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                TreeNode p = queue.poll();
                if(p.left != null) queue.add(p.left);
                if(p.right != null) queue.add(p.right);
                if(i == n - 1) res.add(p.val);
            }
        }
        return res;
    }
}
//************************************ DFS *************************************//
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}