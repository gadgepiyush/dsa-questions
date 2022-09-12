package solvedArchive.Graph;

public class NoOfIslands {

    public static void main(String[] args) {
        char arr[][] = {{'1','1','0','0','0'},
                        {'1','1','1','0','0'},
                        {'0','0','0','0','0'},
                        {'0','1','1','1','1'}};


        System.out.println(noOfIslands(arr));
    }

    //leetcode 200 count no of Islands
    static int noOfIslands(char grid[][]){
        int count = 0;

        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j]=='1'){
                    count++;
                    checkIsland(i, j, grid);
                }
            }
        }

        return count;
    }

    static void checkIsland(int row, int col, char grid[][]){

        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length)
            return;

        if(grid[row][col]=='0')
            return;

        grid[row][col] = '0';         //simply turning the visited cells as '0' instead of maintaining a visited grid

        checkIsland(row, col+1, grid);
        checkIsland(row+1, col, grid);
        checkIsland(row, col-1, grid);
        checkIsland(row-1, col , grid);

    }


    //leetcode 695 max area Island
    static int maxAreaIsland(char grid[][]){
        int maxArea = 0;

        for(int i = 0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j]=='1'){
                    int x = checkArea(i ,j, grid);
                    maxArea = Math.max(x, maxArea);
                }
            }
        }

        return maxArea;
    }

    static int checkArea(int row, int col, char grid[][]){

        if(row<0 || col<0 || row>=grid.length || col>= grid[0].length)
            return 0;

        if(grid[row][col]=='0')
            return 0;

        grid[row][col]='0';

        int right = checkArea(row, col+1, grid);
        int down = checkArea(row+1, col, grid);
        int left = checkArea(row, col-1, grid);
        int up = checkArea(row-1, col, grid);

        return 1 + (right+left+up+down);
    }
}


//        {{'1','1','1','1','0'},
//        {'1','1','0','1','0'},
//        {'1','1','0','0','0'},
//        {'0','0','0','0','0'}};