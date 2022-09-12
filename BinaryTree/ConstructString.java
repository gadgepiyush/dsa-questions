package solvedArchive.BinaryTree;

public class ConstructString{
    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.left.right = new BTNode(4);
        root.right = new BTNode(3);

        StringBuilder sb = new StringBuilder();
       // sb.append("");

        System.out.println(helper(root));

    }

    static String helper(BTNode root){
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
