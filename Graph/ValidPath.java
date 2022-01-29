package solvedArchive.Graph;
import java.util.*;

public class ValidPath {

    public static void main(String[] args) {

        int edges[][] = {{0,1},{3,2}};
        System.out.println(validPath(4, edges, 0, 2));


    }

    //finding weather valid path exists between source and destination using BFS
    static boolean validPath(int n, int edges[][], int source, int destination){

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0 ; i<n ; i++)
            adj.add(new ArrayList<>());

        //creating an adjacency list
        for(int i[] : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        boolean visited[] = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();

        q.add(source);
        visited[source] = true;

        while(!q.isEmpty()){

            int currNode = q.poll();

            if(currNode==destination)
                return true;

            for(int i : adj.get(currNode)){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }

        }

        return false;
    }

}
