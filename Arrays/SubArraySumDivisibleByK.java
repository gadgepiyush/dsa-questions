package solvedArchive.Arrays;

import java.util.HashMap;
import java.util.Map;


//leetcode - 974
public class SubArraySumDivisibleByK {
    public static void main(String[] args) {
        int arr[] = {-1, 2, 9};

        System.out.println(subarraysDivByK(arr, 2));
     }

    static int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i : nums){
            currSum += i;

            int rem = currSum%k;

            if(rem<0){
                rem += k;
            }

            if(map.containsKey(rem)){
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0)+1);
        }

        return count;
    }
}
