package solvedArchive.BinarySearchTree;

public class LowestCommonAncestor {

    static TreeNode lca(TreeNode root, int i, int j){

        if(root==null)
            return null;

        if(root.val<i && root.val<j)
            return lca(root.right, i, j);

        if(root.val>i && root.val>j)
            return lca(root.left, i, j);

        return root;
    }
}
