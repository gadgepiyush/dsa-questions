package solvedArchive.Graph;
import java.util.*;

public class Graph {

    List<List<Integer>> adj = new ArrayList<>();

    // taking no of vertexes in the constructor
    Graph(int v){
        for(int i=0 ; i<v ; i++)
            adj.add(i, new ArrayList<>());
    }

    //adds edge in undirected graph
    void addEdgeUD(int source, int destination){
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }


    //adds edge in directed graph
    void addEdgeD(int source, int direction){
        adj.get(source).add(direction);
    }

}







