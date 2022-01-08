package solvedArchive.RecursionBacktracking;
import java.util.*;


public class NQueens {
    public static void main(String[] args) {

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
}
