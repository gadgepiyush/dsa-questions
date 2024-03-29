package solvedArchive.Arrays;
import java.util.*;

public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    static List<List<Integer>> generate(int n){
        List<List<Integer>> pascalsTriangle = new ArrayList<>();

        for(int i=0 ; i<n ; i++){
            List<Integer> temp = new ArrayList<>();

            for(int j=0 ; j<=i ; j++){
                if(j==0 || j==i)
                    temp.add(1);
                else
                    temp.add(pascalsTriangle.get(i-1).get(j-1) + pascalsTriangle.get(i-1).get(j));
            }

            pascalsTriangle.add(temp);
        }

        return pascalsTriangle;
    }
}
