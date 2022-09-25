package solvedArchive.Graph;

// leetcode 542. 01 Matrix
public class Matrix01{
    public static void main(String[] args) {
        int arr[][] = {  {0,0,0}
                        ,{0,1,0},
                         {1,1,1} };

        updateMatrix(arr);
    }

    static int[][] updateMatrix(int arr[][]){
        int res[][] = new int[arr.length][arr[0].length];
        for(int i=0 ; i< arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++)
                if(arr[i][j]==1)
                    res[i][j] = -1;
        }



        return res;
    }
}
