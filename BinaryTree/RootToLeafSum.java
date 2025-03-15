package solvedArchive.BinaryTree;

import java.util.ArrayList;
import java.util.List;

//leetcode 129
public class RootToLeafSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        leftNode.left = new TreeNode(4);
        leftNode.right = new TreeNode(7);

        leftNode.left.left = new TreeNode(8);

        rightNode.left = new TreeNode(5);
        rightNode.right = new TreeNode(6);

        List<Integer> x = new ArrayList<>();
        helper(root, 0, x);
        System.out.println(x);

    }

    static void helper(TreeNode root, int x, List<Integer> ls){
        if(root.left==null && root.right==null){
            ls.add(root.val +x*10);
            return;
        }

        int temp =  x*10+root.val;
        if(root.left!=null)
            helper(root.left, temp, ls);

        if(root.right!=null)
            helper(root.right, temp , ls);
    }
}
