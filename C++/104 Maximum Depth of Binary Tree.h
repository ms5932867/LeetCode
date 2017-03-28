/*
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int maxDepth(TreeNode *root) {
        if (root == NULL)
            return 0;
        queue<TreeNode *> q;
        q.push(root);
        int maxDep = 0;
        while(!q.empty()){
            int n = q.size();
            while(n-- > 0){
                TreeNode *t = q.front();
                q.pop();
                if(t->left != NULL) q.push(t->left);
                if(t->right != NULL) q.push(t->right);
            }
            maxDep++;
        }
        return maxDep;
    }
};

class Solution {
public:
    int maxDepth(TreeNode *root) {
        if (root == NULL)
            return 0;
        return max(maxDepth(root->left), maxDepth(root->right)) + 1;
    }
};