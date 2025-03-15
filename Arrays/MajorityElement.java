package solvedArchive.Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] a = {1};

        System.out.println(majorityElement(a));
    }

    static int majorityElement(int A[]){
        HashSet<Integer> set = new HashSet<>();

        for(int i : A){
           if(set.contains(i)){
               set.remove(i);
           }
           else {
               set.add(i);
           }
        }

        int j = 0;
        for(int i : set){
            j = i;
        }
        return j;
    }
}
