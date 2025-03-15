package solvedArchive.BinaryTree;

public class LowestCommonAncestor {

    static TreeNode lca(TreeNode root, int i, int j){

        if(root==null || root.val==i || root.val==j)
            return root;

        TreeNode left = lca(root.left, i, j);
        TreeNode right = lca(root.right, i, j);

        if(left==null)
            return right;

        if(right==null)
            return left;

        return root;
    }

}
