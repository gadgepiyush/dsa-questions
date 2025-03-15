package solvedArchive.BinarySearchTree;

//convert array to balanced tree (i.e. height of left and right subtree is the same)
public class ArrayToBST {

    public static void main(String[] args){
        int arr[] = {-10, -5, 0, 5, 9};

        BSTBasic.inOrderTraversal(arrayToBST(arr));
    }

    static TreeNode arrayToBST(int arr[]){
        if(arr.length==0)
            return null;

        return helper(0, arr.length-1, arr);
    }

    //using binary search
    static TreeNode helper(int start, int end, int arr[]){
        if(start>end)
            return null;

        int mid = (start+end)/2;
        TreeNode currNode = new TreeNode(arr[mid]);
        currNode.left = helper(start, mid-1, arr);
        currNode.right = helper(mid+1, end, arr);

        return currNode;
    }

}
