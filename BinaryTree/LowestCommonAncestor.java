package solvedArchive.BinaryTree;

public class LowestCommonAncestor {

    static BTNode lca(BTNode root, int i, int j){

        if(root==null || root.val==i || root.val==j)
            return root;

        BTNode left = lca(root.left, i, j);
        BTNode right = lca(root.right, i, j);

        if(left==null)
            return right;

        if(right==null)
            return left;

        return root;
    }

}
