package solvedArchive.RecursionBacktracking;
import java.util.*;

//leetcode 46
public class Permutations {
    public static void main(String[] args) {
//        int arr[] = {1, 2, 3};
//        List<List<Integer>> temp = new ArrayList<>();
//
//        permutationArray(arr, new ArrayList<>(), temp);
//        System.out.println(temp);


        permutationsString("abc", 0);
    }

    //approach 1
    static void permutationArray(int arr[], List<Integer> temp, List<List<Integer>> temp2){
        if(temp.size()==arr.length){
            temp2.add(List.copyOf(temp));
            return;
        }

        for(int i : arr){
            if(temp.contains(i))
                continue;

            temp.add(i);
            permutationArray(arr, temp, temp2);
            temp.remove(temp.size()-1);
        }
    }

    //approach 2
    static void permutationsString(String str, int i){
        if(i==str.length()){
            System.out.println(str);
            return;
        }

        for(int j=i ; j<str.length() ; j++){
            str = swapper(str, i, j);
            permutationsString(str, i+1);
            str = swapper(str ,i, j);
        }
    }


    static String swapper(String str, int i, int j){
        char arr[] = str.toCharArray();

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return String.copyValueOf(arr);
    }

}
