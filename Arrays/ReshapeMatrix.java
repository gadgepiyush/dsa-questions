package solvedArchive.Arrays;

public class ReshapeMatrix {

    public static void main(String[] args) {
        int mat[][] = {{1,0}, {3,4}, {5,7}};

        for(int i[] : reShape(mat, 1,0)){
            for(int j : i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    static int[][] reShape(int[][] mat, int r, int c){

        int m =mat.length;
        int n = mat[0].length;

        if(m*n != r*c)
            return mat;

        int row = 0;
        int col = 0;
        int result[][] = new int[r][c];

        for(int i=0 ; i<m ; i++){
            for (int j=0 ; j<n ; j++){
                result[row][col] = mat[i][j];
                col++;

                if(col==c){
                    col=0;
                    row++;
                }
            }
        }

        return result;

    }
}
