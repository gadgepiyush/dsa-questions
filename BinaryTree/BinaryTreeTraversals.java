package solvedArchive.BinaryTree;

//different methods containing various traversal methods

public class BinaryTreeTraversals {

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

        System.out.println(sizeOfBT(root));

    }

    //inorder traversal (left -> value -> right)
    static void inOrderTraversal(BTNode root){

        if(root==null)  return;

        inOrderTraversal(root.left);

        //printing value at that node after call at the left Node is finished and calling the right Node after that
        System.out.print(root.val + " -> ");

        inOrderTraversal(root.right);
    }


    //preorder traversal (value -> left -> right)
    static void preOrderTraversal(BTNode root){

        if(root==null)  return;

        //printing the value at that node first and then calling left Node and calling right Node after that
        System.out.print(root.val + "->");

        preOrderTraversal(root.left);

        preOrderTraversal(root.right);
    }


    //postorder traversal (left -> right -> value)
    static void postOrderTraversal(BTNode root){

        if(root==null)  return;

        postOrderTraversal(root.left);

        postOrderTraversal(root.right);

        //printing the left and right Node first then printing the value at that Node
        System.out.print(root.val + " -> ");
    }


    // counts the number of nodes in the binary tree
    static int sizeOfBT(BTNode root){
        if(root==null)
            return 0;

        int left = sizeOfBT(root.left);
        int right = sizeOfBT(root.right);

        return left+right+1;
    }

}





