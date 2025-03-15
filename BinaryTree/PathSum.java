package solvedArchive.BinaryTree;
import java.util.ArrayList;
import java.util.List;

/*
    Given the root of a binary tree and an integer targetSum,
    return all root-to-leaf paths where the sum of the node values
    in the path equals targetSum
*/

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22, new ArrayList<>()));
    }

    //leetcode 113
    static List<List<Integer>> pathSum(TreeNode root, int currSum, List<Integer> list){
        if(root==null)
            return new ArrayList<>();

        if(root.left==null && root.right==null){
            if(currSum-root.val==0){
                List<Integer> newList = new ArrayList<>(list);
                newList.add(root.val);
                List<List<Integer>> temp = new ArrayList<>();
                temp.add(newList);
                return temp;
            }
            else
                return new ArrayList<>();
        }

        list.add(root.val);
        List<List<Integer>> leftCall = pathSum(root.left, currSum-root.val , list);
        List<List<Integer>> rightCall = pathSum(root.right, currSum-root.val, list);

       list.remove(list.size()-1);

        leftCall.addAll(rightCall);

        return leftCall;
    }

}
