package solvedArchive.BinaryTree;

//leetcode 998
public class SmallestString {
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

        System.out.println(helper(root));

    }


    static String helper(TreeNode root){
        if(root.left==null && root.right==null){
            return Character.toString(root.val+97);
        }

        String left = "";
        if(root.left!=null){
            left = helper(root.left);
            left += Character.toString(root.val+97);
        }

        String right = "";
        if(root.right!=null){
            right = helper(root.right);
            right += Character.toString(root.val+97);
        }

        String res = left.compareTo(right)<0 ? left : right;

        if(left.equals(""))
            return right;
        else  if(right.equals(""))
            return left;

        return res;
    }
}
