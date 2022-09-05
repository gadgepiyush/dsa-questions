package solvedArchive.Arrays;
import java.util.*;

//leetcode 287
public class FindDuplicate {
    public static void main(String[] args) {
        int arr[] = {3,1,3,4,2};

        System.out.println(findDuplicate(arr));
    }


    //brute force
    static int findDuplicate(int arr[]){
        int i=0, j;

        while(i<arr.length){
            j = i+1;
            while(j<arr.length){
                if(arr[i]==arr[j])
                    return arr[j];

                j++;
            }

            i++;
        }

        return 1;
    }


    //optimized
    static int findDuplicate1(int arr[]){
        Set<Integer> set = new HashSet<>();

        for(int i=0 ; i<arr.length ; i++){
            if(set.contains(arr[i]))
                return arr[i];
            else
                set.add(arr[i]);
        }

        return 0;
    }
}
