package solvedArchive.RecursionBacktracking;
import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        int arr[] = {10,1,2,7,6,1,5};
        Arrays.sort(arr);
        List<List<Integer>> temp = new ArrayList<>();

        helper(arr, 0, 8, new ArrayList<>(), temp);

        System.out.println(temp);
    }

    static void helper(int arr[], int i, int target, List<Integer> temp, List<List<Integer>> temp2){
        if(target==0){
            temp2.add(List.copyOf(temp));
            return;
        }

        if(i==arr.length || target<0)
            return;


        temp.add(arr[i]);
        helper(arr, i+1, target-arr[i], temp, temp2);
        temp.remove(temp.size()-1);

        while(i+1<arr.length && arr[i]==arr[i+1])
            i++;

        helper(arr, i+1, target, temp, temp2);

    }
}
