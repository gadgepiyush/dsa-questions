package solvedArchive.Graph;

import java.util.Scanner;

public class GraphMethods{

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("enter the no of vertices and edges");
        int vertex = sc.nextInt();
        int edges = sc.nextInt();

        Graph graph = new Graph(vertex);

        for(int i=0 ; i<edges ; i++){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.addEdge(source, destination);
        }

        graphPrinter(graph);

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
