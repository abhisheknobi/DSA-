package Step13_BinaryTrees;


import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
    public static void main() {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.right.right=new Node(5);

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
    private static List<Integer> preoder(Node root) {
       List<Integer> res=new ArrayList<>();
       helper(root,res);
       return res;
    }

    private static void helper(Node root, List<Integer> res) {
        if(root==null)
            return ;
        res.add(root.data);
        helper(root.left,res);
        helper(root.right,res);

    }
}
