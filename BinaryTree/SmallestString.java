package solvedArchive.BinaryTree;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;

//leetcode 998
public class SmallestString {
    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);

        BTNode leftNode = root.left;
        BTNode rightNode = root.right;

        leftNode.left = new BTNode(4);
        leftNode.right = new BTNode(7);

        leftNode.left.left = new BTNode(8);

        rightNode.left = new BTNode(5);
        rightNode.right = new BTNode(6);

        System.out.println(helper(root));

    }


    static String helper(BTNode root){
        if(root.left==null && root.right==null){
            return Character.toString(root.val+97);
        }

        String left = "";
        if(root.left!=null){
            left = helper(root.left);
            left += Character.toString(root.val+97);
        }

        String right = "";
        if(root.right!=null){
            right = helper(root.right);
            right += Character.toString(root.val+97);
        }

        String res = left.compareTo(right)<0 ? left : right;

        if(left.equals(""))
            return right;
        else  if(right.equals(""))
            return left;

        return res;
    }
}
