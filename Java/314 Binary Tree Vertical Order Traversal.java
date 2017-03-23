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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // BFS, map : col -> vals
        // idea : root.col = 0, left child col = parent col - 1, right child col = parent col + 1
        // two queue
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        nq.add(root);
        cq.add(0);
        int minC = 0, maxC = 0;
        while(!nq.isEmpty()){
            TreeNode cur = nq.poll();
            int col = cq.poll();
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
                minC = Math.min(minC, col);
                maxC = Math.max(maxC, col);
            }
            map.get(col).add(cur.val);
            if(cur.left != null){
                nq.add(cur.left);
                cq.add(col - 1);
            }
            if(cur.right != null){
                nq.add(cur.right);
                cq.add(col + 1);
            }
        }
        
        for(int k = minC; k <= maxC; k++){
            res.add(map.get(k));
        }
        return res;
    }
}