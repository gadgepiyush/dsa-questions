package solvedArchive.RecursionBacktracking;

import java.util.*;


class BacktrackingMethods{

    //return all permutations of an array
    static List<List<Integer>> permutations (List<Integer> arr, int start, int end){

        if (start == end){
            List<List<Integer>> ls = new ArrayList<>();
            ls.add(new ArrayList<>(arr));
            return ls;
        }

        List<List<Integer>> permutationList = new ArrayList<>();
        for(int i=start ; i<end ; i++){
            Collections.swap(arr, start,i);
            permutationList.addAll(permutations(arr, start+1, end));
            Collections.swap(arr, start, i);
        }

        return permutationList;
    }

    //find all unique permutations is list has duplicate elements
    static void permUnique(List<Integer> arr, List<List<Integer>> permList, int start, int end){
        if(start==end){
            permList.add(new ArrayList<>(arr));
            return ;
        }

        for(int i=start ; i<end ; i++){
            Collections.swap(arr, start,i);
            if(!permList.contains(arr)){
                permUnique(arr, permList, start + 1, end);
            }
            Collections.swap(arr, start, i);
        }
    }

    //maze question all direction movements allowed (without obstacle)
    static void backtrack(int row, int col, String route, boolean status[][]){

        //base case
        if(row==status.length-1 && col==status[0].length-1){
            System.out.println(route);
            status[row][col] = false;
            return;
        }

        if(status[row][col]){
            return;
        }

        status[row][col] = true;

        if(row < status.length-1){
            backtrack(row+1, col, route+"D", status);
        }

        if(col < status[0].length-1){
            backtrack(row, col+1, route+"R", status);
        }

        if(row>0){
            backtrack(row-1, col, route+"U", status);
        }

        if(col>0){
            backtrack(row, col-1, route+"L", status);
        }

        status[row][col] = false;
    }


    //rat in a maze question path print
    static void ratMazePrint(int row, int col, String route, boolean status[][], int obs[][]){


        if(obs[row][col] == 0)
            return;

        //base case
        if(row==status.length-1 && col==status[0].length-1){
            System.out.println(route);
            return;
        }

        if(status[row][col]){
            return;
        }

        status[row][col] = true;

        if(row < status.length-1){
            ratMazePrint(row+1, col, route+"D", status, obs);
        }

        if(col < status[0].length-1){
            ratMazePrint(row, col+1, route+"R", status, obs);
        }

        if(row>0){
            ratMazePrint(row-1, col, route+"U", status, obs);
        }

        if(col>0){
            ratMazePrint(row, col-1, route+"L", status, obs);
        }

        status[row][col] = false;
    }

    //rat in a maze return list of path
    static List<String> ratMaze(int row, int col, String route, boolean status[][], int obstacle[][]){


        if(obstacle[row][col]==0){
            return new ArrayList<>();
        }

        //base case
        if(row==status.length-1 && col==status[0].length-1){
            List<String> ls = new ArrayList<>();
            ls.add(route);
            return ls;
        }


        if(status[row][col]){
            return new ArrayList<>();
        }

        List<String> arr = new ArrayList<>();
        status[row][col] = true;

        if(row < status.length-1)
            arr.addAll(ratMaze(row+1, col, route + "D", status, obstacle));


        if(col < status.length-1)
            arr.addAll(ratMaze(row, col+1, route +"R", status, obstacle));


        if(row > 0)
            arr.addAll(ratMaze(row-1, col, route+"U", status, obstacle));


        if(col > 0)
            arr.addAll(ratMaze(row, col-1, route+"L", status, obstacle));


        status[row][col]= false;

        return arr;
    }

}

public class Backtracking {

    public static void main(String[] args) {



    }

}
