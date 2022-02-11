package solvedArchive.BinaryTree;
import java.util.Stack;

//converting binary tree into linked-list


public class FlattenBT {

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

        flattenBT(root);

        BinaryTreeTraversals.preOrderTraversal(root);
    }

    static BTNode prev = null;
    static void flattenBT(BTNode root){
        if(root==null)
            return;

        flattenBT(root.right);
        flattenBT(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    static void flattenBT2(BTNode root){
        if(root==null)
            return;

        Stack<BTNode> st = new Stack<>();
        st.push(root);

        while(st.isEmpty()){
            BTNode currNode = st.pop();

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
