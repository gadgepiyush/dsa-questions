package solvedArchive.Graph;
import java.util.*;

public class ShortestPath{

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdgeUD(0,1);
        graph.addEdgeUD(0,4);
        graph.addEdgeUD(1,2);
        graph.addEdgeUD(2,3);

        System.out.println(shortestPath(0, graph.adj));
    }


    //calculating shortest paths in Undirected graph from given source
    static List<Integer> shortestPath(int source ,List<List<Integer>> adj){

        Queue<Integer> q = new LinkedList<>();
        List<Integer> distances = new ArrayList<>(Collections.nCopies(adj.size(), Integer.MAX_VALUE-1));

        q.add(source);
        distances.set(source, 0);

        while(!q.isEmpty()){
            int currNode = q.poll();

            for(int j : adj.get(currNode)){
                if(distances.get(currNode)+1 < distances.get(j)){
                    q.add(j);
                    distances.set(j, distances.get(currNode)+1);
                }

            }
        }

        return distances;
    }


}
