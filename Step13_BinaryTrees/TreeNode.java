package Step13_BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        data=val;
        left=null;
        right=null;
    }
    public static TreeNode buildTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            // Process Left Child
            if (i < nodes.length && nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.add(current.left);
            }
            i++;

            // Process Right Child
            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}
