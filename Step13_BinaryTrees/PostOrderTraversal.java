package Step13_BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
     static void main() {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.right.right=new TreeNode(5);

        List<Integer> result=postoder(root);
        System.out.print("Preorder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    static List<Integer> postoder(TreeNode root){
         List<Integer> res=new ArrayList<>();
         helper(root,res);
         return res;
    }

    static void helper(TreeNode root, List<Integer> res){
         if(root==null)
            return;
         helper(root.left,res);
         helper(root.right,res);
         res.add(root.data);

    }
}
