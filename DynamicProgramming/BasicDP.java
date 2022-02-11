package solvedArchive.DynamicProgramming;

/*
    top-down -> Memoization(recursive)
    bottom-up -> Tabulation(iterative)
*/

public class BasicDP {
    public static void main(String[] args) {

        System.out.println(mazePathDiag(0,0,new int[3][3]));
    }

    //calculating fibonacci no. using DP (time complexity O(N))
    static int fibonacci(int n, int value[]){
        if(n<2)
            return n;

        if(value[n]!=0)
            return value[n];

        int n1 = fibonacci(n-1, value);

        int n2 =fibonacci(n-2, value);

        value[n] = n1 + n2;

        return n1 + n2;
    }


    //no of maze-path to reach end using DP (top-down approach)
    static int mazePath1(int row, int col, int grid[][]){
        if(row==grid.length-1 && col==grid[0].length-1)
            return 1;

        if(row>=grid.length || col>=grid[0].length)
            return 0;

        if(grid[row][col]!=0)
            return grid[row][col];

        int right = mazePath1(row, col+1, grid);
        int down = mazePath1(row+1, col, grid);

        grid[row][col] = right+down;

        return right+down;
    }

    //no of maze-path to reach end using DP (bottom-up approach)
    static int mazePath2(int row, int col){

        int grid[][] = new int[row+1][col+1];
        grid[row-1][col-1] = 1;

        for(int i=row-1 ; i>=0 ; i--){
            for(int j=col-1 ; j>=0 ; j--){
                if(i!=row-1 || j!=col-1){
                    grid[i][j] = grid[i + 1][j] + grid[i][j + 1];
                }
            }
        }

        for(int i[] : grid){
            for(int j : i){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        return grid[0][0];
    }

    //no of maze-path to reach end diagonal allowed (top-down approach)
    static int mazePathDiag(int row, int col, int grid[][]){
        if(row==grid.length-1 && col==grid[0].length-1)
            return 1;

        if(row>=grid.length|| col>=grid[0].length)
            return 0;

        if(grid[row][col]!=0)
            return grid[row][col];

        int right = mazePathDiag(row+1, col, grid);
        int down = mazePathDiag(row, col+1, grid);
        int diag = mazePathDiag(row+1, col+1, grid);

        grid[row][col] = right+down+diag;

        return right+down+diag;
    }

}

