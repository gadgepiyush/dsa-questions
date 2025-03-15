package solvedArchive.Arrays;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {-5, 8, -14, 2, 4, 12};
        int k = -5;

        System.out.println(longestSubArraySumK(arr, k));
    }

    static int longestSubArraySumK(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int currSum = 0;

        for(int i=0 ; i<arr.length ; i++){
            currSum += arr[i];

            if(currSum == k){
                maxLen = Math.max(maxLen,i+1);
            }

            int rem = currSum - k;

            if(map.containsKey(rem)){
                maxLen = Math.max(maxLen, i-map.get(rem));
            }
            if(!map.containsKey(currSum)){
                map.put(currSum, i);
            }
        }

        return maxLen;
    }
}
