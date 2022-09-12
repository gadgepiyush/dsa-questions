package solvedArchive.RecursionBacktracking;
import java.util.*;

//leetcode 46
public class Permutations {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        List<List<Integer>> temp = new ArrayList<>();

        helper(arr, new ArrayList<>(), temp);
        System.out.println(temp);
    }

    static void helper(int arr[], List<Integer> temp, List<List<Integer>> temp2){
        if(temp.size()==arr.length){
            temp2.add(List.copyOf(temp));
            return;
        }

        for(int i : arr){
            if(temp.contains(i))
                continue;

            temp.add(i);
            helper(arr, temp, temp2);
            temp.remove(temp.size()-1);
        }
    }
}
