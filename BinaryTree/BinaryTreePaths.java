package solvedArchive.BinaryTree;
import java.util.*;

//leetcode 257
public class BinaryTreePaths{
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

        System.out.println(binaryTreePaths(root));
    }


    static public List<String> binaryTreePaths(BTNode root) {
        List<String> temp = new ArrayList<>();

        helper(root, "", temp);

        return temp;
    }

    static void helper(BTNode root, String str, List<String> ls){
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
