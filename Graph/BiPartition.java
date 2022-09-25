    package solvedArchive.Graph;
    import java.util.*;


    public class BiPartition{

        public static void main(String[] args) {

            Graph graph = new Graph(4);
            graph.addEdgeUD(0,2);
            graph.addEdgeUD(0,3);
            graph.addEdgeUD(2,1);
            graph.addEdgeUD(1,3);

            int dislikes[][] = {{1,2},{2,3},{3,4},{4,5},{1,5}};

            System.out.println(possibleBiPartition(5, dislikes));
        }

        static boolean checkBipartiteBFS(int V, List<List<Integer>> adj){

            int colors[] = new int[V];  //colors can be '1' or '2'

            for(int i=0 ; i<V ; i++){
                if(colors[i]==0){
                    if(!checkBipartiteBFSHelper(i , adj, colors))
                        return false;
                }
            }

            return true;
        }

        static boolean checkBipartiteBFSHelper(int source, List<List<Integer>> adj, int colors[]){

            Queue<Integer> q = new ArrayDeque<>();
            q.add(source);
            colors[source] = 1;

            while(!q.isEmpty()){
                int currNode = q.poll();
                int currColor = colors[currNode];

                for(int i : adj.get(currNode)){
                    if(colors[i]!=0){  //already colored
                        if(colors[i]==currColor)
                            return false;
                    }
                    else{ // not already colored
                        q.add(i);
                        colors[i] = (currColor==1) ? 2:1 ;
                    }
                }

            }

            return true;
        }


        //leetcode 886 possible Bi-partition
        static boolean possibleBiPartition(int n, int dislikes[][]){

            List<List<Integer>> adj = new ArrayList<>();
            for(int i=0 ; i<=n ; i++)
                adj.add(new ArrayList<>());

            for(int i[] : dislikes){
                adj.get(i[0]).add(i[1]);
                adj.get(i[1]).add(i[0]);
            }

            int colors[] = new int[n+1];
            for(int i=1 ; i<=n ; i++){
                if(colors[i]==0) {
                    if(!possibleBiPartitionHelper(i, colors, adj))
                        return false;
                }
            }

            return true;
        }

        static boolean possibleBiPartitionHelper(int source, int colors[], List<List<Integer>> adj){

            Queue<Integer> q = new ArrayDeque<>();
            q.add(source);
            colors[source] = 1;

            while(!q.isEmpty()){

                int currNode = q.poll();
                int currColor = colors[currNode];

                for(int i : adj.get(currNode)){
                    if(colors[i]!=0){
                        if(colors[i]==currColor)
                            return false;
                    }
                    else{
                        q.add(i);
                        colors[i] = currColor==1 ? 2:1;
                    }
                }
            }

            return true;
        }
    }
