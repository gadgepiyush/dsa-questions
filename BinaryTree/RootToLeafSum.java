package solvedArchive.BinaryTree;

import java.util.ArrayList;
import java.util.List;

//leetcode 129
public class RootToLeafSum {
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

        List<Integer> x = new ArrayList<>();
        helper(root, 0, x);
        System.out.println(x);

    }

    static void helper(BTNode root, int x, List<Integer> ls){
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
