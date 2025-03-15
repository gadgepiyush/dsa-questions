package solvedArchive.BinarySearchTree;
import java.util.*;

public class TwoSumInBST {

    //two sum by doing inorder traversal and operating the returned list
    static boolean twoSum(TreeNode root, int target){

        List<Integer> ls = new ArrayList<>();
        inOrderTraversal(root, ls);

        int start = 0;
        int end = ls.size()-1;
        while(start<end){
            if(ls.get(start)+ls.get(end)==target)
                return true;

            if(ls.get(start)+ls.get(end)<target){
                start++;
            }
            else {
                end--;
            }
        }

        return false;
    }

    static void inOrderTraversal(TreeNode root , List<Integer> ls){
        if(root==null)
            return;

        inOrderTraversal(root.left, ls);

        ls.add(root.val);

        inOrderTraversal(root.right, ls);
    }


    //two sum using hashset
    static boolean twoSumHashset(TreeNode root, int target, Set<Integer> set){

        if(root==null || root.val>target)
            return false;

        if(set.contains(target - root.val))
            return true;
        else
            set.add(root.val);


        return twoSumHashset(root.left, target, set) || twoSumHashset(root.right, target, set);
    }

}
