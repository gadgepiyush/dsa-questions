package solvedArchive.BinaryTree;
import java.util.*;

public class BinaryTreeTraversalsLvl2 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

       // leftNode.left = new TreeNode(4);
        //leftNode.right = new TreeNode(7);

        //leftNode.left.left = new TreeNode(8);

        rightNode.left = new TreeNode(15);
        rightNode.right = new TreeNode(7);

        //levelOrderTraversalNew(root);

        System.out.println(levelOrderTraversalNew(root));

    }


    // height of BT (Time complexity O(N))
    static int heightOfBT(TreeNode root){
        if(root==null)
            return 0;

        int left = heightOfBT(root.left);
        int right =  heightOfBT(root.right);

        return Math.max(left,right) + 1;
    }

    static int minDepthOfBT(TreeNode root){
        if(root==null)
            return 0;

        int left = minDepthOfBT(root.left);
        int right = minDepthOfBT(root.right);

        if(left==0 || right==0)    //this condition is there if the tree is skewed
            return Math.max(left, right);

        return Math.min(left, right);
    }

    //diameter of a BT (Brute force) (Time complexity O(N^2))
    static int diameterOfBT1(TreeNode root){
        if(root==null)
            return 0;

        int d1 = diameterOfBT1(root.left);
        int d2 = diameterOfBT1(root.right);

        int curr = heightOfBT(root.left) +heightOfBT(root.right) + 1;

        return Math.max(curr, Math.max(d1, d2));
    }


    //diameter of a BT optimized (Time complexity O(N))
//    static int diameterOfBT2(BTNode root){
//
//    }


    //level-order traversal (Brute Force) (Time complexity O(N^2))
    static void levelOrderTraversal1(TreeNode root){

        int height = heightOfBT(root);

        for(int i=1 ; i<=height ; i++){
            levelOrderHelper(root, i);
        }

    }

    //helper for the brute force approach
    static void levelOrderHelper(TreeNode root, int level){

        if(root==null)  return;

        if(level==1) {
            System.out.print(root.val + " ");
            return;
        }

        levelOrderHelper(root.left, level-1);
        levelOrderHelper(root.right, level-1);
    }


    //level-order traversal (Optimized) (Time complexity O(N))
    static void levelOrderTraversal2(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        while(!queue.isEmpty()){
            TreeNode currNode = queue.poll();

            System.out.print(currNode.val+" ");

            if(currNode.left!=null)
                queue.add(currNode.left);


            if(currNode.right!=null)
                queue.add(currNode.right);

        }
    }

    //level order traversal return List
    static List<List<Integer>> levelOrderTraversal3(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        ls.add(root.val);
        levels.add(ls);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> temp = new ArrayList<>();

        while (!queue.isEmpty()){

            TreeNode currNode = queue.poll();

            if(currNode==null){
                if(!queue.isEmpty()){
                    queue.add(null);
                    levels.add(temp);
                    temp = new ArrayList<>();
                    continue;
                }
                break;
            }

            if(currNode.left!=null) {
                queue.add(currNode.left);
                temp.add(currNode.left.val);
            }

            if(currNode.right!=null) {
                queue.add(currNode.right);
                temp.add(currNode.right.val);
            }

        }

        return levels;
    }

    static List<List<Integer>> levelOrderTraversalNew(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            List<Integer> currList = new ArrayList<>();
            Queue<TreeNode> tempQ = new LinkedList<>();
            //traverse all the elements present in the current queue
            while (!q.isEmpty()){
                TreeNode curr = q.poll();
                currList.add(curr.val);

                if(curr.left!=null)
                    tempQ.add(curr.left);

                if(curr.right!=null)
                    tempQ.add(curr.right);
            }

            res.add(new ArrayList<>(currList));
            q = new LinkedList<>(tempQ);
        }

        return res;
    }
}




