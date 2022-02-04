package solvedArchive.Graph;
import java.util.*;

public class DisjointSet{

    public static void main(String[] args){

        int edges[][] = {{1,2}, {1,3} ,{2,3}};

        for(int i : cycle(3, edges))
            System.out.print(i+" ");

    }

    //cycle detection using Disjoint set (this doesn't  work on directed graph only on undirected graph)
    static int[] cycle(int n,int edges[][]){

        int parent[] = new int[n+1];
        Arrays.fill(parent, -1);


        for(int i[] : edges){
            if(union(i[0], i[1], parent)){
                return i;
            }
        }

        return new int[]{};
    }

    //checks if i and j belong to same set if yes return true
    static boolean union(int i, int j, int parent[]){
        int p1 = find(i, parent);
        int p2 = find(j, parent);

        if(p1==p2)
            return true;

        parent[p1] = p2;

        return false;
    }

    //function for finding the rank of each node
    static int find(int i, int ds[]){
        if(ds[i] == -1)
            return i;

        return find(ds[i], ds);
    }
}
