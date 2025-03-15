package solvedArchive.BinaryTree;

public class ConstructString{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);

        StringBuilder sb = new StringBuilder();
       // sb.append("");

        System.out.println(helper(root));

    }

    static String helper(TreeNode root){
        if(root==null)
            return "";

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        if(root.left==null && root.right!=null){
            sb.append("()");
        }

        String left = helper(root.left);
        if(!left.equals(""))
            sb.append("("+left+")" );

        String right = helper(root.right);
        if(!right.equals(""))
            sb.append("("+right+")" );

        return sb.toString();
    }
}
