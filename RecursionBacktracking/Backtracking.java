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


    // nQueen problem
    static void nQueens(boolean[][] board, List<List<String>> finalList, int row){
        //base case
        if(row == board.length){
            addToList(board, finalList);
            return;
        }

        for(int col=0 ; col<board.length ; col++){
            if(isSafeNQueen(board, row, col)){
                board[row][col] = true;
                nQueens(board, finalList, row+1);
                board[row][col] = false;
            }
        }

    }

    // isSafe func for nQueen
    static boolean isSafeNQueen(boolean[][] board, int row, int col){

        //checking above
        for(int i=0 ; i<row ; i++){
            if(board[i][col])
                return false;
        }

        //checking diagonally left
        int leftBound = Math.min(row,col);
        for (int i=0 ; i<=leftBound ; i++){
            if(board[row-i][col-i]){
                return false;
            }
        }

        //checking diagonally right
        int rightBound = Math.min(row, board.length-col-1);
        for (int i=1 ; i<=rightBound ; i++){
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }

    static void addToList(boolean[][] board, List<List<String>> finalList){
        List<String> strings = new ArrayList<>();
        for(boolean[] listBool : board){
            String s = "";
            for(boolean val : listBool){
                s = val ? s.concat("Q") : s.concat(".");
            }
            strings.add(s);
        }
        finalList.add(strings);
    }


    // nKnights problem
    static void nKnights(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            return;
        }

        if (row == board.length - 1 && col == board.length)   return;


        if (col == board.length) {
            nKnights(board, row + 1, 0, knights);
            return;
        }

        if (isSafeNKnights(board, row, col)) {
            board[row][col] = true;
            nKnights(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        nKnights(board, row, col + 1, knights);
    }

    //isSafe for nKnights
    static boolean isSafeNKnights(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }

        return true;
    }

    // is valid for nKnights
    static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board) {
            for(boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }



}

public class Backtracking {

    public static void main(String[] args) {



    }

}
