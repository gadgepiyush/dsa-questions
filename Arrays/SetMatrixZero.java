package solvedArchive.Arrays;
import java.util.*;

public class SetMatrixZero {
    public static void main(String[] args) {
        int matrix[][] = {  {0,1,2,0},
                            {3,4,5,2},
                            {1,3,1,5}};

        setZeros(matrix);

        for(int i[] : matrix){
            for(int j : i)
                System.out.print(j+" ");

            System.out.println();
        }
    }

    static void setZeros(int matrix[][]){
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[0].length ;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i : row) {
            for(int j=0 ; j<matrix[0].length ; j++)
                matrix[i][j] = 0;
        }

        for(int i : col) {
            for(int j=0 ; j<matrix.length ; j++)
                matrix[j][i] = 0;
        }
    }
}
