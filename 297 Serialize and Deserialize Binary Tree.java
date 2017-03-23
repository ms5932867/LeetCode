
/* 297. Serialize and Deserialize Binary Tree
Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, or transmitted across a network connection 
link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how 
your serialization/deserialization algorithm should work. You just need to ensure that a binary 
tree can be serialized to a string and this string can be deserialized 
to the original tree structure.
*/
public class Codec {

    // Encodes a tree to a single string.
	// use null as null pointer, use ' ' to split nodes
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> qu = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        qu.offer(root);
        sb.append(String.valueOf(root.val));
        sb.append(' ');
        while (!qu.isEmpty()) {
            TreeNode x=qu.poll();
            if (x.left == null) sb.append("null ");
            else {
                qu.offer(x.left);
                sb.append(String.valueOf(x.left.val));
                sb.append(' ');
            }
            if (x.right == null) sb.append("null ");
            else {
                qu.offer(x.right);
                sb.append(String.valueOf(x.right.val));
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] node = data.split(" ");
        Queue<TreeNode> qu = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(node[0]));
        qu.offer(root);
        int i = 1;
        while (!qu.isEmpty()) {
            Queue<TreeNode> nextQu = new LinkedList<>();
            while (!qu.isEmpty()) {
                TreeNode x = qu.poll();
                if (node[i].equals("null")) x.left = null;
                else {
                    x.left = new TreeNode(Integer.valueOf(node[i]));
                    nextQu.offer(x.left);
                }
                i++;
                if (node[i].equals("null")) x.right = null;
                else {
                    x.right = new TreeNode(Integer.valueOf(node[i]));
                    nextQu.offer(x.right);
                }
                i++;
            }
            qu = nextQu;
        }
        return root;
    }
}