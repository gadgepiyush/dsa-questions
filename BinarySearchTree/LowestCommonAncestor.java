package solvedArchive.BinarySearchTree;

public class LowestCommonAncestor {

    static BSTNode lca(BSTNode root, int i, int j){

        if(root==null)
            return null;

        if(root.val<i && root.val<j)
            return lca(root.right, i, j);

        if(root.val>i && root.val>j)
            return lca(root.left, i, j);

        return root;
    }
}
