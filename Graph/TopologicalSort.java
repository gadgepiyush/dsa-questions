package solvedArchive.Graph;

import java.util.*;

public class TopologicalSort{

    public static void main(String[] args) {

        Graph graph = new Graph(5);
        graph.addEdgeD(0,1);
        graph.addEdgeD(0,2);
        graph.addEdgeD(1,3);
        graph.addEdgeD(2,3);
        graph.addEdgeD(4, 2);

       int courses[][] = {{1,0},{2,1},{3,2},{4,3},{1,4}};

       for(int i : topologicalSortBFS(5, graph.adj)){
           System.out.print(i+" ");
       }

    }

    //topo sort using dfs
    static int[] topologicalSortDFS(List<List<Integer>> adj){
        boolean visited[] = new boolean[adj.size()];
        Stack<Integer> st = new Stack<>();

        for(int i=0 ; i<adj.size() ; i++){
            if(!visited[i])
                helper(i, visited, st, adj);
        }

        int arr[] = new int[adj.size()];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = st.pop();
        }


        return arr;
    }


    static void helper(int currNode, boolean visited[], Stack<Integer> st, List<List<Integer>> adj){
        visited[currNode] = true;

        for(int i : adj.get(currNode)){
            if(!visited[i])
                helper(i, visited, st, adj);
        }

        st.push(currNode); //push the current vertex after all its neighbours are visited
    }



    //topological sorting using BFS (kahn's algo)
    static int[] topologicalSortBFS(int n, List<List<Integer>> adj){

        int indegree[] = new int[n];

        //adding the in-degrees of each vertex
        for(List<Integer> ls: adj){
            for(int i : ls)
                indegree[i]++;
        }

        Queue<Integer> q = new LinkedList<>();

        //adding the elements which have in-degree '0' in queue
        for(int i=0 ; i<n ; i++){
            if(indegree[i]==0)
                q.add(i);
        }

        int answer[] = new int[n];
        int i=0;
        while(!q.isEmpty()){
            int currNode = q.poll();
            answer[i] = currNode;
            i++;

            for(int j : adj.get(currNode)){
                indegree[j]--;
                if(indegree[j]==0){
                    q.add(j);
                }
            }
        }

        return answer;

    }


    //leetcode 210 course schedule-2
    static int[] courseSchedule(int n, int prerequisites[][]){

        List<List<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[n];

        for(int i=0 ; i<n ; i++)
            adj.add(new ArrayList<>());


        for(int i[] : prerequisites){
            adj.get(i[1]).add(i[0]);
            indegree[i[0]]++;
        }


        Queue<Integer> q = new LinkedList<>();

        for(int i=0 ; i<n ; i++){
            if(indegree[i]==0) {
                q.add(i);
            }
        }

        int i=0;
        int answer[] = new int[n];

        while(!q.isEmpty()){
            int currNode = q.poll();
            answer[i] = currNode;
            i++;

            for(int j : adj.get(currNode)){
                indegree[j]--;
                if(indegree[j]==0){
                    q.add(j);
                }
            }
        }


        return i==n ? answer : new int[0];
    }

}





