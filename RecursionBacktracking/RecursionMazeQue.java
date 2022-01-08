package solvedArchive.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

class RecursionMazeMethods{

    //print no of ways of reaching from (row,col) to (1,1)
    static int noOfMovesMaze(int row, int column){

        if(row==1 || column==1){
            return 1;
        }

        //this takes the player in the downward direction and right takes it rightward
        int down = noOfMovesMaze(row-1, column);
        int right = noOfMovesMaze(row, column-1);


        return down+right;
    }


    //printing the maze route taken to reach end
    static void mazeRoutePrint(int row, int col, String route){

        if(row==1 || col==1){
            if(row==1){
                for (int i=0; i<col-- ; i++) {
                    route = route.concat("➡");
                }
            }
            else {
                for (int i=0; i<row-- ; i++) {
                    route= route.concat("⬇");
                }
            }

            System.out.println(route);
            return;
        }

        mazeRoutePrint(row-1, col, route+"⬇");
        mazeRoutePrint(row, col-1, route+"➡");


    }


    //returns a list containing paths taken to reach at end
    static List<String> mazePathMethod1(int row, int col, String route){

        if(row==1 || col==1){

            if(row==1){
                for (int i=0; i<col-1 ; i++) {
                    route=route.concat("R");
                }
            }
            else {
                for (int i=0 ; i<row-1 ; i++){
                    route = route.concat("D");
                }
            }

            List<String> ls = new ArrayList<>();
            ls.add(route);
            return ls;
        }

        List<String> down = mazePathMethod1(row-1, col, route+"D");
        List<String> right = mazePathMethod1(row, col-1, route+"R");

        down.addAll(right);


        return down;
    }

    static List<String> mazePathMethod2(int row, int col, String route){

        if(row==1 && col==1){
            List<String> ls = new ArrayList<>();
            ls.add(route);
            return ls;
        }

        List<String> down = new ArrayList<>();
        List<String> right = new ArrayList<>();

        if(row>1)
            down = mazePathMethod2(row - 1, col, route + "D");

        if(col>1)
            right = mazePathMethod2(row, col - 1, route + "R");


        down.addAll(right);

        return down;

    }


    //returns a list containing paths taken to reach end (diagonal movement allowed)
    static List<String> mazePathDiagonal(int row, int col, String route){

        if(row==1 && col==1){

            List<String> ls = new ArrayList<>();
            ls.add(route);
            return ls;
        }


        List<String> path = new ArrayList<>();

        //recursion call for going diagonally
        if(row>1 && col>1)
            path.addAll(mazePathDiagonal(row-1, col-1, route+"Dia"));


        //recursion call for going down
        if(row>1)
            path.addAll(mazePathDiagonal(row-1, col, route+"Ver"));


        //recursion call for going right
        if(col>1)
            path.addAll(mazePathDiagonal(row, col-1, route+"Hor"));



        return path;
    }


    //returns a list containing paths taken to reach end (there's an obstacle there if obstacle[row][col]==1)
    static List<String> mazePathObstacle(int row, int col, String route, int[][] obstacle){

        if(row==obstacle.length-1 && col==obstacle[0].length-1){
            List<String> ls = new ArrayList<>();
            ls.add(route);
            return ls;
        }

        List<String> temp= new ArrayList<>();

        if(obstacle[row][col]==1){
            return new ArrayList<>();
        }

        if(row < obstacle.length-1)
            temp.addAll(mazePathObstacle(row+1, col, route+"D", obstacle));

        if(col < obstacle[0].length-1){
            temp.addAll(mazePathObstacle(row, col+1, route+"R", obstacle));
        }

        return temp;
    }

}


public class RecursionMazeQue {
    public static void main(String[] args) {

    }
}
