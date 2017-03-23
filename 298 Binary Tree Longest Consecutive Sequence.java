public int longestConsecutive(TreeNode root) {
    // ret[0] is the max length when includes node "root", 
    // ret[1] is the max length when doesn't include node "root"
    int[] ret = helper(root); 
    return Math.max(ret[0], ret[1]);
}

private int[] helper(TreeNode root) {
    int[] ret = new int[2];
    if (root == null) {
        return ret;
    }
    int[] a = helper(root.left);
    int[] b = helper(root.right);
    int m = 1;
    if (root.left != null && root.left.val == root.val+1) {
        m = a[0] +1;
    }
    if (root.right != null && root.right.val == root.val+1) {
        m = Math.max(m, b[0]+1);
    }
    ret[0] = m;
    ret[1] = Math.max(Math.max(a[0], a[1]), Math.max(b[0], b[1]));
    return ret;
}

public class Solution {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root, root.val, 0);
        return max;
    }
    
    private void helper(TreeNode root, int target, int curLen){
        if(root == null) return;
        if(root.val == target) curLen++;
        else curLen = 1;
        max = Math.max(max, curLen);
        helper(root.left, root.val + 1, curLen);
        helper(root.right, root.val + 1, curLen);
    }
}