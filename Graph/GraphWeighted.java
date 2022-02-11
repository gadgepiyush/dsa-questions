package solvedArchive.Graph;
import java.util.ArrayList;
import java.util.List;

/*
    each node will have
    index 0 = destination
    index 1 = weight
*/

public class GraphWeighted{

    List<List<List<Integer>>> adj = new ArrayList<>();

    GraphWeighted(int v){
        for(int i=0 ; i<v ; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdgeUD(int source, int destination, int weight){
        adj.get(source).add(new ArrayList<>());
        adj.get(source).get(adj.get(source).size()-1).add(destination);
        adj.get(source).get(adj.get(source).size()-1).add(weight);

        adj.get(destination).add(new ArrayList<>());
        adj.get(destination).get(adj.get(destination).size()-1).add(source);
        adj.get(destination).get(adj.get(destination).size()-1).add(weight);
    }

    void addEdgeD(int source, int destination, int weight){
        adj.get(source).add(new ArrayList<>());
        adj.get(source).get(adj.get(source).size()-1).add(destination);
        adj.get(source).get(adj.get(source).size()-1).add(weight);
    }

}
