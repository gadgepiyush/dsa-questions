package solvedArchive.Graph;

import java.util.*;

public class GraphMethods{

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int vertex = sc.nextInt();
        int edges = sc.nextInt();

        Graph graph = new Graph(vertex);

        for(int i=0 ; i<edges ; i++){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.addEdgeD(source, destination);
        }


        System.out.println(BFSTraversal(0, graph.adj));

    }


    //traversing all nodes of the graph using bfs
    static List<Integer> BFSTraversal(int source, List<List<Integer>> adj){

        List<Integer> bfs = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean visited[] = new boolean[adj.size()];

        visited[source] = true;
        queue.add(source);

        while(!queue.isEmpty()){
            int curr = queue.poll();
            bfs.add(curr);              //add the currNode in the list

            for(int i : adj.get(curr)){ //add the neighbours of the currNode in the queue is not visited
                if(!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        return bfs;
    }


    static List<Integer> DFSTraversal(int source, List<List<Integer>> adj, boolean visited[]){

        List<Integer> dfs = new ArrayList<>();
        dfs.add(source);
        visited[source] = true;

        for(int i : adj.get(source)){
            if(!visited[i]){
                dfs.addAll(DFSTraversal(i, adj, visited));
            }
        }

        return dfs;
    }


    static void graphPrinter(Graph graph){
        for(int i=0 ; i<graph.adj.size() ; i++){
            System.out.print(i+" index: ");
            for(int j=0 ; j<graph.adj.get(i).size() ; j++){
                System.out.print(graph.adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}



/*5
7
0 1
0 2
0 3
1 3
2 3
2 4
3 4


*/