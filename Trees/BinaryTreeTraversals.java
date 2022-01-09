package solvedArchive.Trees;


public class BinaryTreeTraversals {

    public static void main(String[] args) {

        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);

        BTNode leftNode = root.left;
        BTNode rightNode = root.right;

        leftNode.left = new BTNode(4);

        rightNode.left = new BTNode(5);
        rightNode.right = new BTNode(6);

        System.out.println(root.right.left.val);

    }

}
