package solvedArchive.RecursionBacktracking;
import java.util.*;

//leetcode 39
public class CombinationSum{
    public static void main(String[] args) {
        List<List<Integer>> temp = new ArrayList<>();
        int arr[] = {2,3,6,7};
        helper(arr, 0, 7, new ArrayList<>(), temp);

        System.out.println(temp);
    }

    static void helper(int arr[], int i, int target, List<Integer> temp, List<List<Integer>> temp2){
        if(target==0){
            temp2.add(List.copyOf(temp));
            return;
        }
        if(i>=arr.length || target<0)
            return;

        temp.add(arr[i]);
        helper(arr, i, target-arr[i], temp, temp2);
        temp.remove(temp.size()-1);

        helper(arr, i+1, target, temp, temp2);
    }
}
