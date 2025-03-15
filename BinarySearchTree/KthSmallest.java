package solvedArchive.BinarySearchTree;


//leetcode 230
public class KthSmallest {
    public static void main(String[] args) {
        TreeNode bstNode = new TreeNode(3);
        bstNode.left = new TreeNode(1);
        bstNode.right = new TreeNode(4);

        System.out.println(kthSmallest(bstNode, 1));
    }

    static int k;
    static int res;
    static int kthSmallest(TreeNode root, int k) {
        KthSmallest.k = k;
        helper(root);
        return res;
    }

    static void helper(TreeNode root){
        if(root==null)
            return;

        if(k<=0)
            return;

        helper(root.left);

        k--;
        if(k==0)
            res = root.val;

        helper(root.right);
    }
}
