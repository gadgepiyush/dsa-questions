package solvedArchive.Trees;

//A custom BinaryTree Node which we'll be using in different traversal methods
class BTNode {
    int val;
    BTNode left;
    BTNode right;

    public BTNode(int x){
        this.val = x;
        left = null;
        right = null;
    }
}