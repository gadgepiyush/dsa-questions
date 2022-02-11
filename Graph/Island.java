package solvedArchive.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Island {
    public static void main(String[] args) {

        int gird[][] = { {1,1}
                        ,{1,1}};

        System.out.println(largeIsland(gird));;
    }

    //leetcode hard largest possible area of an island
    static int largeIsland(int grid[][]){
        Map<Integer,Integer> map = new HashMap<>();
        int flag = 2;

        int maxArea = 0;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j]==1){
                    int currArea = area(i, j, flag, grid);
                    map.put(flag, currArea);
                    maxArea = Math.max(maxArea, currArea);
                    flag++;
                }
            }
        }


        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j]==0){
                    int x = maxArea(i, j, grid, map);
                    maxArea = Math.max(maxArea, x);
                }
            }
        }

        return maxArea;
    }

    static int area(int row, int col, int flag, int grid[][]){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length)
            return 0;

        if(grid[row][col]!=1)
            return 0;

        grid[row][col] = flag;

        int right = area(row, col+1, flag, grid);
        int down = area(row+1, col, flag, grid);
        int left = area(row, col-1, flag, grid);
        int up = area(row-1, col, flag, grid);

        return (right+left+down+up) +1;
    }

    static int maxArea(int row, int col, int grid[][], Map<Integer, Integer> map){
        Set<Integer> set = new HashSet<>();
        int right = maxAreaCheck(row, col+1, grid, map, set);
        int down = maxAreaCheck(row+1, col, grid, map, set);
        int left = maxAreaCheck(row, col-1, grid, map, set);
        int up = maxAreaCheck(row-1, col, grid, map, set);

        return (right+left+down+up) +1;
    }

    static int maxAreaCheck(int row, int col, int grid[][], Map<Integer, Integer> map, Set<Integer> set){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length)
            return 0;

        if(grid[row][col]==0 || set.contains(grid[row][col]))
            return 0;

        set.add(grid[row][col]);
        return map.get(grid[row][col]);
    }
}
