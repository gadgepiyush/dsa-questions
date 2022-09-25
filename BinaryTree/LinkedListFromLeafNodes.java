package solvedArchive.BinaryTree;

public class LinkedListFromLeafNodes {
    static BTNode head = null;
    static BTNode curr = null;

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

        traverseLL(llFromLeaf(root));
    }

    static BTNode llFromLeaf(BTNode root){

        helper(root);

        return head;
    }


    static void helper(BTNode root){
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


    static void traverseLL(BTNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.left;
        }
    }
}
