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
        BTNode root = new BTNode(5);
        root.left = new BTNode(4);
        root.left.left = new BTNode(11);
        root.left.left.left = new BTNode(7);
        root.left.left.right = new BTNode(2);

        root.right = new BTNode(8);
        root.right.left = new BTNode(13);
        root.right.right = new BTNode(4);
        root.right.right.left = new BTNode(5);
        root.right.right.right = new BTNode(1);

        System.out.println(pathSum(root, 22, new ArrayList<>()));
    }

    //leetcode 113
    static List<List<Integer>> pathSum(BTNode root, int currSum, List<Integer> list){
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
