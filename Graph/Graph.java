package solvedArchive.Graph;
import java.util.*;

public class Graph {

    List<List<Integer>> adj = new ArrayList<>();

    Graph(int v){
        for(int i=0 ; i<v ; i++)
            adj.add(i, new ArrayList<>());
    }

    void addEdge(int source, int destination){
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }

}







