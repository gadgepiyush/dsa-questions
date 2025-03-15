package solvedArchive.BinaryTree;
import java.util.*;

public class BinaryTreeViews {

    //Left view of BT (Time complexity O(N))
    //we're doing simple recursive traversal, just checking the level is visited the first time if yes then add the val
    static void leftView(TreeNode root, int level, List<Integer> ls){

        if(root==null)  return;

        if(level==ls.size())
            ls.add(root.val);

        leftView(root.left, level+1, ls);
        leftView(root.right, level+1, ls);
    }


    //Top view of BT (iterative)
    //using simple level order traversal and maintaining the queue containing (node, level) pair
    static void topView1(TreeNode root){
        class Pair{
            TreeNode node;
            int level;
            Pair(TreeNode node, int level){
                this.node = node;
                this.level = level;
            }
        }

        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));

        while (!queue.isEmpty()){
            Pair currNode= queue.poll();

            map.putIfAbsent(currNode.level, currNode.node.val); // adding if the given level is not present

            if(currNode.node.left!=null)
                queue.add(new Pair(currNode.node.left, currNode.level-1));


            if(currNode.node.right!=null)
                queue.add(new Pair(currNode.node.right, currNode.level+1));

        }

        System.out.print(map);
    }


    //Bottom view of BT (iterative)
    //only change is we use "put" instead of "putIfAbsent" just to get the bottom most node of that level
    static void bottomView1(TreeNode root){

        class Pair{
            TreeNode node;
            int level;
            Pair(TreeNode node, int level){
                this.node = node;
                this.level = level;
            }
        }

        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()){
            Pair currNode = queue.poll();

            map.put(currNode.level, currNode.node.val);  //overriding the level if present

            if(currNode.node.left!=null)
                queue.add(new Pair(currNode.node.left, currNode.level-1));


            if(currNode.node.right!=null)
                queue.add(new Pair(currNode.node.right, currNode.level+1));
        }

        //printing the values
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
            System.out.print(entry.getValue()+" ");


    }


}



/*

    //Top view of BT (recursive)
    static void topView2(BTNode root, int level, int height,Map<Integer,Pair<Integer,Integer>> map){

        if(root==null)
            return;



        topView2(root.left, level-1, height, map);
        topView2(root.right, level+1, height, map);

    }
*/