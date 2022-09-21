package solvedArchive.BinarySearchTree;

//leetcode 1008
public class BSTFromPre{
    public static void main(String[] args) {
        int arr[] = {8,5,1,7,10,12};

        BSTBasic.inOrderTraversal(bstFromPreorder(0, arr.length-1 , arr));
    }


    static BSTNode bstFromPreorder(int start, int end, int preOrder[]){
        if(start>end)
            return null;

        BSTNode root = new BSTNode(preOrder[start]);

        int idx = start+1;
        while(idx<=end){
            if(preOrder[idx]>preOrder[start])
                break;

            idx++;
        }

        root.left = bstFromPreorder(start+1, idx-1, preOrder);
        root.right = bstFromPreorder(idx, end, preOrder);

        return root;
    }
}
