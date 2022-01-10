package solvedArchive.Trees;

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


        levelOrderTraversal1(root);

    }

    // height of BT (Time complexity O(N))
    static int heightOfBT(BTNode root) {
        if(root==null)
            return 0;

        int left = heightOfBT(root.left);
        int right =  heightOfBT(root.right);

        return Math.max(left,right) + 1;
    }


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



}
