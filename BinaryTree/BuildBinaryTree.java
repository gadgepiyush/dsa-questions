package solvedArchive.BinaryTree;
import java.util.HashMap;

public class BuildBinaryTree{
    public static void main(String[] args) {
        int pre[] = {3,9,20,15,7};
        int in[] = {9,3,15,20,7};

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<in.length ; i++)
            map.put(in[i], i);

        System.out.println(map);

    }


    static BTNode helper(int preStart, int inStart, int inEnd, int pre[], int in[], HashMap<Integer,Integer> map){
        if(preStart>=pre.length || inStart>inEnd)
            return null;

        BTNode root = new BTNode(pre[preStart]);

        int inIndex = map.get(root.val);

        root.left = helper(preStart+1, inStart, inIndex-1, pre, in, map);
        root.right = helper(preStart+inIndex-inStart+1, inIndex+1, inEnd, pre, in, map );

        return root;
    }
}
