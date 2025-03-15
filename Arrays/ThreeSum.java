package solvedArchive.Arrays;

import java.util.*;

//leetcode - 15
public class ThreeSum {
    public static void main(String[] args) {
        int arr [] = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(arr));
    }

    static List<List<Integer>> threeSum(int arr[]){
        Arrays.sort(arr);
        Set<List<Integer>> set = new HashSet<>();

        for(int i=0 ; i<arr.length-2 ; i++){
            //fix the number at index i
            int fixNum = arr[i];
            int start = i+1;
            int end = arr.length-1;

            while (start<end){
                int sum = fixNum + arr[start] + arr[end];

                if(sum == 0){
                    set.add(Arrays.asList(fixNum, arr[start], arr[end]));
                    start++;
                    end--;
                }
                else if(sum>0){
                    end--;
                }
                else {
                    start++;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
