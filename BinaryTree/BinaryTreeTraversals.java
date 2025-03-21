package solvedArchive.BinaryTree;

//different methods containing various traversal methods

public class BinaryTreeTraversals {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        leftNode.left = new TreeNode(4);
        leftNode.right = new TreeNode(7);

        leftNode.left.left = new TreeNode(8);

        rightNode.left = new TreeNode(5);
        rightNode.right = new TreeNode(6);



    }


    //inorder traversal (left -> value -> right)
    static void inOrderTraversal(TreeNode root){

        if(root==null)  return;

        inOrderTraversal(root.left);

        //printing value at that node after call at the left Node is finished and calling the right Node after that
        System.out.print(root.val + " -> ");

        inOrderTraversal(root.right);
    }


    //preorder traversal (value -> left -> right)
    static void preOrderTraversal(TreeNode root){

        if(root==null)  return;

        //printing the value at that node first and then calling left Node and calling right Node after that
        System.out.print(root.val + "->");

        preOrderTraversal(root.left);

        preOrderTraversal(root.right);
    }


    //postorder traversal (left -> right -> value)
    static void postOrderTraversal(TreeNode root){

        if(root==null)  return;

        postOrderTraversal(root.left);

        postOrderTraversal(root.right);

        //printing the left and right Node first then printing the value at that Node
        System.out.print(root.val + " -> ");
    }


    // counts the number of nodes in the binary tree
    static int sizeOfBT(TreeNode root){
        if(root==null)
            return 0;

        int left = sizeOfBT(root.left);
        int right = sizeOfBT(root.right);

        return left+right+1;
    }




}





