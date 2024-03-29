package solvedArchive.Graph;
import java.util.*;

/*
    In Spanning tree
    (no. of edges = no. of vertices - 1)
    Spanning tree is a subset of the graph which has minimum no of edges covering all the vertices
    A Spanning tree will not have any cycle

    A disconnected Graph cannot have Spanning tree
*/


public class MinSpanningTree {

    public static void main(String[] args) {

        GraphWeighted graph = new GraphWeighted(3);
        graph.addEdgeUD(0,1,5);
        graph.addEdgeUD(0,2,1);
        graph.addEdgeUD(1,2,3);


        System.out.println(primsMST(graph.adj));;
    }

    //Kruskal's algo (returns the sum of weights of formed MST)
    static int mstKruskal(int V, List<List<List<Integer>>> adj){

        class Pair{
            int source;
            int destination;
            int weight;
            Pair(int s, int d, int w){
                this.source = s;
                this.destination = d;
                this.weight = w;
            }
        }

        int parent[] = new int[V];
        Arrays.fill(parent, -1);
        int edges = 0;
        int sum = 0;

        Queue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2) {
                if(p1.weight > p2.weight)
                    return 1;
                else if(p1.weight < p2.weight)
                    return -1;

                return 0;
            }
        });

        for(int i=0 ; i<V ; i++){
            for(List<Integer> ls : adj.get(i)){
                pq.add(new Pair(i, ls.get(0), ls.get(1)));
            }
        }

        //loop runs until the no of edges have become ((no of vertex)-1)
        while(edges<V-1){
            Pair p = pq.poll();

            if(!union(p.source, p.destination, parent)){
                edges++;
                sum += p.weight;
            }
        }

        return sum;
    }

    //this can be optimised using rank array (check DisjointSet.java file for optimal approach)
    static boolean union(int i, int j, int parent[]){
        int p1 = find(i, parent);
        int p2 = find(j, parent);

        if(p1==p2)
            return true;

        parent[p1] = p2;

        return false;
    }

    //returns parent of given node
    static int find(int i, int parent[]){
        if(parent[i]==-1)
            return i;

        return find(parent[i], parent);
    }


    //Prim's algo
    static int primsMST(List<List<List<Integer>>> adj){
        System.out.println(adj);
        int weight = 0;
        boolean visited[] = new boolean[adj.size()];

        Queue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                if(l1.get(1)>l2.get(1))
                    return 1;
                else if(l1.get(1)<l2.get(1))
                    return -1;

                return 0;
            }
        });

        List<Integer> temp = new ArrayList<>();
        temp.add(0); //source
        temp.add(0); //weight of source is initially zero
        visited[0] = true;

        pq.add(temp);

        while(!pq.isEmpty()){
            List<Integer> currNode = pq.poll();
            visited[currNode.get(0)]  = true;
            System.out.print(currNode.get(0)+" ");

            int idx = -1;
            int minDist = Integer.MAX_VALUE;
            for(List<Integer> nodes : adj.get(currNode.get(0))){
                //find the min distance
                if(!visited[nodes.get(0)]){
                    if(nodes.get(1)<minDist){
                        idx = nodes.get(0);
                        minDist = nodes.get(1);
                    }
                }
            }

            if(idx != -1){
                pq.add(Arrays.asList(idx, minDist));
            }
        }


        return weight;
    }
}


/*
* for(List<List<Integer>> ls : adj)
            pq.addAll(ls);

        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }

| */