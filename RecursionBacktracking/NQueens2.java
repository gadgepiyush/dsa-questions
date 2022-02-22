package solvedArchive.RecursionBacktracking;

//leetcode 52 count the number of ways of placing N-Queens on board
public class NQueens2{
    public static void main(String[] args) {
        System.out.println(nQueens2(4, 0, new boolean[4][4]));
    }

    static int nQueens2(int n, int row, boolean visited[][]){
        if(row==n)
            return 1;

        int total = 0;
        for(int col=0 ; col<n ; col++){
            if(isSafe(row, col, visited)){
                visited[row][col] = true;
                total += nQueens2(n, row+1, visited);
                visited[row][col] = false;
            }
        }

        return total;
    }

    static boolean isSafe(int row, int col, boolean visited[][]){

        //checking valid above
        for(int i=row ; i>=0; i--){
            if(visited[i][col])
                return false;
        }

        //checking diagonally left
        int temp1 = row;
        int temp2 = col;
        while(temp1>=0 && temp2>=0){
            if(visited[temp1][temp2])
                return false;

            temp1--;
            temp2--;
        }

        //checking diagonally right
        while(row>=0 && col<visited.length){
            if(visited[row][col])
                return false;

            row--;
            col++;
        }

        return true;
    }

}
