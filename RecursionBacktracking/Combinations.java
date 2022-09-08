package solvedArchive.RecursionBacktracking;
import java.util.*;


//leetcode 77
public class Combinations{
    public static void main(String[] args) {
        List<List<Integer>> temp = new ArrayList<>();
        combine(4, 3, new ArrayList<>(), temp);
        System.out.println(temp);

    }

    static void combine(int n, int k, List<Integer> temp, List<List<Integer>> temp2){
        if(temp.size() == k){
            temp2.add(List.copyOf(temp));
            return;
        }

        if(n==0)
            return;

        temp.add(n);
        combine(n-1, k, temp, temp2);
        temp.remove(temp.size()-1);

        combine(n-1, k, temp, temp2);
    }
}
