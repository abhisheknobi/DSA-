package Step13_BinaryTrees;


import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
    public static void main() {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.right.right=new TreeNode(5);

        List<Integer>result=preoder(root);
        System.out.print("Preorder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    //NLR
    private static List<Integer> preoder(TreeNode root) {
       List<Integer> res=new ArrayList<>();
       helper(root,res);
       return res;
    }

    private static void helper(TreeNode root, List<Integer> res) {
        if(root==null)
            return ;
        res.add(root.data);
        helper(root.left,res);
        helper(root.right,res);

    }
}
