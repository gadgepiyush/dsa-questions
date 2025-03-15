package solvedArchive.BinaryTree;

public class BinaryTreeMethods {

    static boolean SymmetricTree(TreeNode root){

        return root==null || SymmetricTreeHelper(root.left, root.right);
    }

    static boolean SymmetricTreeHelper(TreeNode left, TreeNode right){

        if(left==null || right==null)
            return left==right;

        if(left.val != right.val)
            return false;

        return SymmetricTreeHelper(left.left, right.right) && SymmetricTreeHelper(left.right, right.left);
    }
}
