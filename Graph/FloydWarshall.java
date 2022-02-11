package solvedArchive.Graph;

public class FloydWarshall{
    public static void main(String[] args) {

        int edges[][] = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};

        System.out.println(findCity(5, edges, 2));

    }

    //leetcode-1334 using floyd-warshall
    static int findCity(int n, int edges[][], int threshold){

        int dist[][] = new int[n][n];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(i==j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = 100000;
            }
        }

        for(int i[] : edges){
            dist[i[0]][i[1]] = i[2];
            dist[i[1]][i[0]] = i[2];
        }

        for(int k=0 ; k<n ; k++){
            for(int i=0 ; i<n ; i++){
                for(int j=0 ; j<n ; j++){
                    if(i!=k && j!=k && dist[i][k] + dist[k][j]<dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int minCount = Integer.MAX_VALUE;
        int city = 0;
        for(int i=0 ; i<n ; i++){
            int count = 0;
            for(int j : dist[i]){
                if(j<=threshold)
                    count++;
            }
            if(count-1<=minCount){
                minCount = count-1;
                city=i;
            }
        }

        return city;
    }

}

/*
        for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<n ; j++){
        System.out.print(dist[i][j]+" ");
        }
        System.out.println();
        }

 */