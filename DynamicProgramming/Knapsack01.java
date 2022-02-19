package solvedArchive.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Knapsack01{
    public static void main(String[] args) {

        int arr[] = {1,1,1,1,1};
        System.out.println(targetSum(0, 0, 3, arr, new HashMap<>()));
    }

    //naive recursive code
    static int knapsack(int i, int currWeight, int price[], int weight[]){
        if(i==price.length || currWeight==0)
            return 0;

        int exclude = knapsack(i+1, currWeight, price, weight);

        int include = 0;
        if(weight[i] <= currWeight){
            include = knapsack(i+1, currWeight-weight[i], price, weight) +price[i];
        }

        return Math.max(exclude, include);
    }


    //DP code memoization
    static int knapsackDP(int i, int currWeight, int price[], int weight[], int memo[][]){
        if(currWeight==0 || i==price.length)
            return 0;

        if(memo[i][currWeight]!=0)
            return memo[i][currWeight];

        int exclude = knapsackDP(i+1, currWeight, price, weight, memo);

        int include = 0;
        if(weight[i]<=currWeight)
            include = knapsackDP(i+1, currWeight-weight[i], price, weight, memo) +price[i];

        int ans = Math.max(exclude, include);
        memo[i][currWeight] = ans;

        return ans;
    }


    //given a sum find if the array subset can make that sum
    static boolean subsetSum(int i, int currSum , int arr[], int memo[][]){

        if(currSum==0)
            return true;

        if(i==arr.length)
            return false;

        if(memo[i][currSum]!=0)
            return memo[i][currSum]==2 ? true : false;


        boolean exclude = subsetSum(i+1, currSum, arr, memo);

        boolean include = false;
        if(arr[i]<=currSum)
            include = subsetSum(i+1, currSum-arr[i], arr, memo);

        memo[i][currSum] = exclude || include ? 2 : 1;

        return exclude || include;
    }


    //leetcode 416
    static boolean partitionSubset(int arr[]){
        int sum = 0;
        for(int i : arr)
            sum += i;

        if(sum%2 != 0)
            return false;

        return partitionHelper(0, sum/2, arr, new int[arr.length][sum/2 + 1]);
    }

    static boolean partitionHelper(int i, int currSum, int arr[], int memo[][]){
        if(currSum==0)
            return true;

        if(i==arr.length || currSum<0)
            return false;

        if(memo[i][currSum]!=0)
            return memo[i][currSum]==2 ? true : false;

        boolean exclude = partitionHelper(i+1, currSum, arr, memo);
        boolean include = partitionHelper(i+1, currSum-arr[i], arr, memo);

        memo[i][currSum] = exclude || include ? 2 : 1;

        return exclude || include;
    }


    //leetcode 494
    static int targetSum(int i, int currSum, int target, int arr[], Map<Map.Entry<Integer, Integer>, Integer> memo){
        if(currSum==target && i==arr.length)
            return 1;

        if(i==arr.length)
            return 0;

        if(memo.containsKey(Map.entry(i, currSum)))
            return memo.get(Map.entry(i, currSum));

        int subtract = targetSum(i+1, currSum-arr[i], target, arr, memo);
        int add = targetSum(i+1, currSum+arr[i], target, arr, memo);

        memo.put(Map.entry(i, currSum), subtract+add);

        return subtract+add;
    }

}
