package solvedArchive.BinaryTree;
import java.util.*;

//leetcode 257
public class BinaryTreePaths{
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

        System.out.println(binaryTreePaths(root));
    }


    static public List<String> binaryTreePaths(TreeNode root) {
        List<String> temp = new ArrayList<>();

        helper(root, "", temp);

        return temp;
    }

    static void helper(TreeNode root, String str, List<String> ls){
        StringBuilder sb = new StringBuilder(str);
        sb.append(root.val+"->");

        if(root.left==null && root.right==null){
            String temp = str +root.val;
            ls.add(temp);
            return;
        }

        if(root.left!=null)
            helper(root.left, sb.toString(), ls);

        if(root.right!=null)
            helper(root.right, sb.toString(), ls);
    }
}
