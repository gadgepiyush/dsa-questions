package solvedArchive.RecursionBacktracking;
import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {

    }

    void helper(int arr[], int i, int target, List<Integer> temp, List<List<Integer>> temp2){
        if(target==0){
            temp2.add(List.copyOf(temp));
            return;
        }

        if(target<0){
            
        }
    }
}
