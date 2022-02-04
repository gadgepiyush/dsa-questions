package solvedArchive.Graph;
import java.util.*;

//cloning an Undirected graph (leetcode 133)
//giving each node a new Address and updating its adjacency list

class Node{
    int val;
    List<Node> neighbors;

     Node(int val) {
        this.val = val;
        neighbors = new ArrayList<Node>();
    }

    void addNode(Node destination){
        neighbors.add(destination);
    }
}

public class CloneGraph {
    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        //Node n5 = new Node(5);

        n1.addNode(n2);
        n1.addNode(n4);

        n2.addNode(n1);
        n2.addNode(n3);

        n3.addNode(n2);
        n3.addNode(n4);

        n4.addNode(n3);
        n4.addNode(n1);


        traverse(cloneDFS(n1, new HashMap<>()));

    }

    static Node cloneDFS(Node source, Map<Node, Node> map){

        if(map.containsKey(source))
            return map.get(source);

        Node newAddress = new Node(source.val);
        map.put(source, newAddress);

        for(Node n : source.neighbors){
            newAddress.neighbors.add(cloneDFS(n, map));
        }

        return newAddress;
    }


    static void traverse(Node node){

        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        visited.add(node);

        while(!q.isEmpty()){
            Node currNode = q.poll();

            System.out.println(currNode.val+": "+currNode);

            for(Node n : currNode.neighbors){
                if(!visited.contains(n)){
                    q.add(n);
                    visited.add(n);
                }
            }
        }
    }
}
