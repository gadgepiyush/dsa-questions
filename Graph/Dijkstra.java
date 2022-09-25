package solvedArchive.Graph;
import java.util.*;

/*
    used to find the shortest path in a weighted graph
    it can be used in both directed and undirected graph
    it can be used on both cyclic and acyclic graph
    it doesn't work if graph has negative weights
*/


public class Dijkstra{

    public static void main(String[] args) {

//        GraphWeighted graph = new GraphWeighted(5);
//
//        graph.addEdgeUD(0, 1, 9);
//        graph.addEdgeUD(0, 2, 6);
//        graph.addEdgeUD(0, 3, 1);
//        graph.addEdgeUD(1, 3, 3);
//        graph.addEdgeUD(2, 3, 2);
//        graph.addEdgeUD(1, 4, 2);
//
//        int dis[] = shortestPathDijkstra(0, graph.adj);
//        for(int i=0 ; i<graph.adj.size() ; i++){
//            System.out.println("index: "+i+": " +dis[i]);
//        }

        int flights[][] = {{0,1,100}, {1,2,100}, {0,2,500}};

        System.out.println(cheapestFlight(3, flights, 0, 2, 1));

    }

    //implementation of Dijkstra using priority queue
    static int[] shortestPathDijkstra(int source, List<List<List<Integer>>> adj){

        int distance[] = new int[adj.size()];
        Arrays.fill(distance, Integer.MAX_VALUE );   //initializing all the distances by a very large value
        boolean visited[] = new boolean[adj.size()];

        Queue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                if(l1.get(1) > l2.get(1))
                    return 1;
                else if(l1.get(1) < l2.get(1))
                    return -1;

                return 0;
            }
        });


        List<Integer> temp = new ArrayList<>();
        temp.add(source);
        temp.add(0);

        pq.add(temp);
        visited[source] = true;
        distance[source] = 0;

        while(!pq.isEmpty()){
            List<Integer> currNode = pq.poll();
            visited[currNode.get(0)] = true;

            for(List<Integer> node : adj.get(currNode.get(0))){
                if(!visited[node.get(0)]){
                    if(node.get(1)+distance[currNode.get(0)] < distance[node.get(0)]){

                        distance[node.get(0)] = node.get(1) + distance[currNode.get(0)];

                        List<Integer> ls = new ArrayList<>();
                        ls.add(node.get(0));
                        ls.add(distance[node.get(0)]);

                        pq.add(ls);
                    }
                }
            }
        }

        return distance;
    }


    //leetcode 787 cheapest flights within k stops (will need a update on the Dijkstra)
    static int cheapestFlight(int n, int flights[][], int src , int dst, int k){

        class Pair{
            int val;
            int cost;

            Pair(int val, int cost){
                this.val = val;
                this.cost = cost;
            }
        }

        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0 ; i<n ; i++)
            adj.add(new ArrayList<>());

        for(int i[] : flights)
            adj.get(i[0]).add(new Pair(i[1], i[2]));

        int minCost[] = new int[n];
        Arrays.fill(minCost, 100000);
        boolean visited[] = new boolean[n];

        Queue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
           @Override
           public int compare(Pair p1, Pair p2){
               if(p1.cost > p2.cost)
                   return 1;
               else if(p1.cost < p2.cost)
                   return -1;

               return 0;
           }
        });

        minCost[src] = 0;
        pq.add(new Pair(src, 0));


        while(!pq.isEmpty() && k>=0){
            Pair currNode = pq.poll();
            visited[currNode.val] = true;
            k--;

            for(Pair node : adj.get(currNode.val)){
                if(!visited[node.val]){
                    if(node.cost+minCost[currNode.val] < minCost[node.val]){
                        minCost[node.val] = node.cost + minCost[currNode.val];
                        node.cost = minCost[node.val];
                        pq.add(node);
                    }
                }
            }
        }

        int j=0;
        for(var i : minCost){
            System.out.println(j+"->"+i);
            j++;
        }

        return minCost[dst];
    }
}





/*
class Pair{
    int val;
    int cost;

    Pair(int val, int cost){
        this.val = val;
        this.cost = cost;
    }
}

    List<List<Pair>> adj = new ArrayList<>();
        for(int i=0 ; i<n ; i++)
        adj.add(new ArrayList<>());

        for(int i[] : flights)
        adj.get(i[0]).add(new Pair(i[1], i[2]));


        int minCost[] = new int[n];
        Arrays.fill(minCost, 10000);

        boolean visited[] = new boolean[n];
        Queue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
@Override
public int compare(Pair p1, Pair p2) {
        if(p1.cost > p2.cost)
        return 1;
        else if(p1.cost < p2.cost)
        return -1;

        return 0;
        }
        });

        pq.add(new Pair(src, 0));
        minCost[src] = 0;

        while(!pq.isEmpty()){
        Pair currNode = pq.poll();
        visited[currNode.val] = true;

        for(Pair node : adj.get(currNode.val)){
        if(!visited[node.val]){
        if(node.cost + minCost[currNode.val] < minCost[node.val]){
        minCost[node.val] = node.cost + minCost[currNode.val];
        node.cost = minCost[node.val];
        pq.add(node);
        }
        }
        }

        }

        int j=0;
        for(var i : minCost){
        System.out.println(j+"->"+i);
        j++;
        }

        return minCost[dst];
      */