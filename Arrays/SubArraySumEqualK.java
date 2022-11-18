package solvedArchive.Arrays;

import java.util.HashMap;

//leetcode 560
public class SubArraySumEqualK {
    public static void main(String[] args) {

        int arr[] = {1,2,3};
        System.out.println(subArraySum2(arr,3));

    }

    //prefix sum not optimized
    static int subArraySum(int[] arr, int k) {

        int count =0;

        if(arr[0]==k)
            count++;

        for(int i=1 ; i<arr.length ; i++){
            arr[i] += arr[i-1];
            if(arr[i]==k)
                count++;
        }

        for(int i=1 ; i<arr.length ; i++){
            for(int j=i ; j<arr.length ; j++){
                if (arr[j] - arr[i-1] == k)
                    count++;

            }
        }

        return count;
    }

    //optimized O(N) using hashmap
    static int subArraySum2(int arr[], int k){
        int count = 0;
        //here key:sum , value:count of how many times that sum has occurred
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int currSum = 0;

        for(int i : arr){
            currSum += i;

            if(map.containsKey(currSum-k)){
                count += map.get(currSum-k);
            }

            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }

        return count;
    }

}
