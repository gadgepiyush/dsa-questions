package solvedArchive.Graph;

import java.util.LinkedList;
import java.util.Queue;

//leetcode 994
public class RottenOranges {
    public static void main(String[] args) {
        int arr[][] = {{1,2}};

        System.out.println(orangesRotting(arr));
    }

    static int orangesRotting(int[][] grid){
        int minutes = 0;
        Queue<int[]> queue = new LinkedList<>();

        //find all the rotten oranges and add it to the queue
        for(int i=0 ; i<grid.length ; i++){
            for (int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j]==2)
                    queue.add(new int[]{i,j});
            }
        }

        while (!queue.isEmpty()){
            minutes += helper(grid, queue);
        }

        for(int i=0 ; i<grid.length ; i++){
            for (int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }

        return minutes;
    }

    static int helper(int[][] grid, Queue<int[]> queue){
        int minute = 0;

        Queue<int[]> tempQ = new LinkedList<>();

        while (!queue.isEmpty()){
            int[] currPos = queue.poll();

            int i = currPos[0];
            int j = currPos[1];

            if(i-1>=0 && grid[i-1][j]==1){
                grid[i-1][j] = 2;
                minute = 1;
                tempQ.add(new int[]{i-1, j});
            }

            if(j-1>=0 && grid[i][j-1]==1){
                grid[i][j-1] = 2;
                minute = 1;
                tempQ.add(new int[]{i, j-1});
            }

            if(i+1<grid.length && grid[i+1][j]==1){
                grid[i+1][j] = 2;
                minute = 1;
                tempQ.add(new int[]{i+1, j});
            }

            if(j+1<grid[0].length && grid[i][j+1]==1){
                grid[i][j+1] = 2;
                minute = 1;
                tempQ.add(new int[]{i, j+1});
            }
        }

        queue.addAll(tempQ);
        return minute;
    }

}
