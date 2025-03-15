package solvedArchive.DynamicProgramming;


//https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1
//leetcode - 2035 pending
public class MinimumSumPartition {
    public static void main(String[] args) {
        int arr[] = {1, 6, 11, 5};

        System.out.println(minDifference(arr));
    }

    static int minDifference(int arr[]) {
        int sum = 0;
        for(int i : arr) sum += i;

        return helper(arr, sum, 0, 0, new int[arr.length+1][sum+1]);
    }

    static int helper(int[] arr, int sum, int i, int currSum, int[][] memo){
        // Base case: If we've considered all elements, calculate the difference
        if(i==arr.length){
            int rem = sum - currSum;
            return Math.abs(currSum - rem);
        }

        if(memo[i][currSum]!=0)
            return memo[i][currSum];

        int include = helper(arr, sum, i+1, currSum+arr[i], memo);
        int exclude = helper(arr, sum, i+1, currSum, memo);

        return memo[i][currSum] = Math.min(include, exclude);
    }
}
