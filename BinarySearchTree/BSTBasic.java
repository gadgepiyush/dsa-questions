package solvedArchive.BinarySearchTree;


import java.util.HashSet;

public class BSTBasic{
    public static void main(String[] args) {

        int arr[] = {6,5,1,3,2,8,7,9};
        TreeNode root = null;

        for(int i : arr){
           root = insert(root, i);
        }

        System.out.println(TwoSumInBST.twoSumHashset(root, 19, new HashSet<>()));


    }


    //this could also be done by doing inorder traversal and checking the values coming out are sorted
    static boolean isValidBST(TreeNode root, int min, int max){
        if(root==null)
            return true;

        if(!(root.val>min && root.val<max))
            return false;

        return isValidBST(root.left , min, root.val) && isValidBST(root.right, root.val, max);
    }


    static TreeNode insert(TreeNode root, int value){

        if(root==null)
            return new TreeNode(value);

        if(root.val>value)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }


    static TreeNode delete(TreeNode root, int key){

        if(root==null)
            return null;

        if(key<root.val)
            root.left = delete(root.left, key);

        else if(key>root.val)
            root.right = delete(root.right, key);

        else{
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;

            TreeNode temp = deleteHelper(root.right);   //this method returns the inorder successor
            root.val = temp.val;                       //copying the value of inorder successor in the node
            root.right = delete(root.right, temp.val); // deleting the inorder successor

        }

        return root;
    }


    //this simply returns leftmost(minimum) node in BST
    static TreeNode deleteHelper(TreeNode root){
        if(root.left==null)
            return root;

        return deleteHelper(root.left);
    }


    static TreeNode search(TreeNode root, int value){

        if (root==null || root.val==value)
            return root;

        if(root.val>value)
            return search(root.left, value);

        else
            return search(root.right, value);

    }



    //inorder traversal (left -> value -> right)
    static void inOrderTraversal(TreeNode root){

        if(root==null)  return;

        inOrderTraversal(root.left);

        //printing value at that node after call at the left Node is finished and calling the right Node after that
        System.out.print(root.val + " -> ");

        inOrderTraversal(root.right);
    }

}



/*
    static int ceil(BSTNode root){

    }

    static int floor(BSTNode root){

    }
*/