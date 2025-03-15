package solvedArchive.BinaryTree;
import java.util.Stack;

//converting binary tree into linked-list


public class FlattenBT {

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

        flattenBT(root);

        BinaryTreeTraversals.preOrderTraversal(root);
    }

    static TreeNode prev = null;
    static void flattenBT(TreeNode root){
        if(root==null)
            return;

        flattenBT(root.right);
        flattenBT(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    static void flattenBT2(TreeNode root){
        if(root==null)
            return;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(st.isEmpty()){
            TreeNode currNode = st.pop();

            if(currNode.right != null)
                st.push(currNode.right);

            if(currNode.left != null)
                st.push(currNode.left);

            if (!st.isEmpty())
                currNode.right = st.peek();

            currNode.left = null;
        }
    }


}
