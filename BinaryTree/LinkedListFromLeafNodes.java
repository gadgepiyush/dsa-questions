package solvedArchive.BinaryTree;

public class LinkedListFromLeafNodes {
    static TreeNode head = null;
    static TreeNode curr = null;

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

        traverseLL(llFromLeaf(root));
    }

    static TreeNode llFromLeaf(TreeNode root){

        helper(root);

        return head;
    }


    static void helper(TreeNode root){
        if(root==null)
            return;

        if(root.left==null && root.right==null){ //leaf node if found
            if(head==null){
                head = root;
                curr = head;
            }
            else{
                curr.left = root;
                curr = curr.left;
            }
        }

        helper(root.left);
        helper(root.right);
    }


    static void traverseLL(TreeNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.left;
        }
    }
}
