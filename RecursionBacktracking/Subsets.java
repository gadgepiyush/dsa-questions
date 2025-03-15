package solvedArchive.RecursionBacktracking;
import java.util.*;

public class Subsets{
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};

        List<List<Integer>> lists = new ArrayList<>();

        helper(arr, 0, new ArrayList<>(), lists);
        System.out.println(lists);
    }

    static void subsetsWithoutDup(int[] arr, int i, List<Integer> temp, List<List<Integer>> temp2){
        if(i==arr.length){
            temp2.add(List.copyOf(temp));
            return;
        }

        subsetsWithoutDup(arr, i+1, temp, temp2);

        temp.add(arr[i]);
        subsetsWithoutDup(arr, i+1, temp, temp2);
        temp.remove(temp.size()-1);
    }


    static void subsetsWithDup(int arr[], int i, List<Integer> temp, List<List<Integer>> temp2){
        if(i==arr.length){
            temp2.add(List.copyOf(temp));
            return;
        }

        temp.add(arr[i]);
        subsetsWithDup(arr, i+1, temp, temp2);
        temp.remove(temp.size()-1);

        while(i+1<arr.length && arr[i]==arr[i+1]){
            i++;
        }

        subsetsWithDup(arr, i+1, temp, temp2);
    }

    static void helper(int arr[], int i, List<Integer> curr, List<List<Integer>> list){
        if(i==arr.length){
            list.add(new ArrayList<>(curr));
            return;
        }

        curr.add(arr[i]);
        helper(arr, i+1, curr, list);
        curr.remove(curr.size()-1);

        helper(arr, i+1, curr, list);
    }
}
