package solvedArchive.Graph;
import java.util.*;

public class CycleDetection {

    public static void main(String[] args) {

        int vertex =4;

        Graph graph = new Graph(vertex);
        graph.addEdgeD(0,1);
        graph.addEdgeD(1,2);
        graph.addEdgeD(2,3);
        graph.addEdgeD(0,3);

       // GraphMethods.graphPrinter(graph);

        kahnAlgo(graph.adj);

    }


    //cycle detection using DFS in undirected graph
    static boolean cycleDetectionUD(List<List<Integer>> adj){

        boolean visited[] = new boolean[adj.size()];
        for(int i=0 ; i<adj.size() ; i++){
            if(!visited[i]){
                if(cycleDetectionHelperUD(i, -1, visited, adj))
                    return true;
            }
        }

        return false;
    }

    static boolean cycleDetectionHelperUD(int currNode, int parentNode, boolean visited[], List<List<Integer>> adj){

        visited[currNode] = true;
        for(int i : adj.get(currNode)){
            if(!visited[i]) {
                if (cycleDetectionHelperUD(i, currNode, visited, adj))
                    return true;
            }
            else if(i != parentNode) {
                return true;
            }
        }

        return false;
    }


    //cycle detection using DFS in directed graph
    static boolean cycleDetectionD(List<List<Integer>> adj){

        boolean visited[] = new boolean[adj.size()];
        boolean dfsVisited[] = new boolean[adj.size()];

        for(int i=0 ; i<adj.size() ; i++){
            if(!visited[i]){
                if(cycleDetectionHelperD(i, visited, dfsVisited, adj))
                    return true;
            }
        }

        return false;
    }

    static boolean cycleDetectionHelperD(int currNode, boolean visited[], boolean dfsVisited[],List<List<Integer>> adj){

        visited[currNode] = true;
        dfsVisited[currNode] = true;

        for(int i : adj.get(currNode)){
            if(!visited[i]){
                if(cycleDetectionHelperD(i, visited, dfsVisited, adj))
                    return true;
            }
            else if(dfsVisited[i]){
                return true;
            }
        }

        dfsVisited[currNode] = false;
        return false;
    }


    //using kahn's algo(using BFS to detect cycle in undirected graph)
    static boolean kahnAlgo(List<List<Integer>> adj){

        int indegree[] = new int[adj.size()];

        for(int i=0 ; i<adj.size() ; i++){     // calculating the in-degrees of each node
            for(int j : adj.get(i)){
                indegree[j]++;
            }
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i=0 ; i<adj.size() ; i++){
            if(indegree[i]==0) {
                q.add(i);
                count++;
            }
        }


        while(!q.isEmpty()){
            int currNode = q.poll();

            for(int i : adj.get(currNode)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(indegree[i]);
                    count++;
                }
            }
        }

        return count!=adj.size();
    }

}








