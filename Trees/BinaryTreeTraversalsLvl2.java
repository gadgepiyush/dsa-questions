package solvedArchive.Trees;
import java.awt.image.ImageProducer;
import java.util.*;

public class BinaryTreeTraversalsLvl2 {

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

        System.out.println(diameterOfBT1(root));


    }

    // height of BT (Time complexity O(N))
    static int heightOfBT(BTNode root){
        if(root==null)
            return 0;

        int left = heightOfBT(root.left);
        int right =  heightOfBT(root.right);

        return Math.max(left,right) + 1;
    }

    //diameter of a BT (Brute force) (Time complexity O(N^2))
    static int diameterOfBT1(BTNode root){
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
    static void levelOrderTraversal1(BTNode root){

        int height = heightOfBT(root);

        for(int i=1 ; i<=height ; i++){
            levelOrderHelper(root, i);
        }

    }

    //helper for the brute force approach
    static void levelOrderHelper(BTNode root, int level){

        if(root==null)  return;

        if(level==1) {
            System.out.print(root.val + " ");
            return;
        }

        levelOrderHelper(root.left, level-1);
        levelOrderHelper(root.right, level-1);
    }


    //level-order traversal (Optimized) (Time complexity O(N))
    static void levelOrderTraversal2(BTNode root){

        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);


        while(!queue.isEmpty()){
            BTNode currNode = queue.poll();

            System.out.print(currNode.val+" ");

            if(currNode.left!=null)
                queue.add(currNode.left);


            if(currNode.right!=null)
                queue.add(currNode.right);

        }
    }

    //level order traversal return List
    static List<List<Integer>> levelOrderTraversal3(BTNode root) {

        List<List<Integer>> levels = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        ls.add(root.val);
        levels.add(ls);

        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> temp = new ArrayList<>();

        while (!queue.isEmpty()){

            BTNode currNode = queue.poll();

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


}




