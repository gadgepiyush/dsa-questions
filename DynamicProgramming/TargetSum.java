package solvedArchive.DynamicProgramming;

//leetcode - 494
public class TargetSum {
    public static void main(String[] args) {
        int arr[] = {1,1,1,1,1};

        System.out.println(findTargetSumWays(arr, 0,3, 0, new int[arr.length+1][arr.length+1]));
    }

    static int findTargetSumWays(int[] arr, int j,int target, int curr, int memo[][]) {
        return helper(arr, target, 0, 0);
    }

    static int helper(int[] arr, int k, int i, int currSum){
        if(i==arr.length)
            return currSum==k ? 1 : 0;

        int minus = helper(arr, k, i+1, currSum-arr[i]);
        int plus = helper(arr, k, i+1, currSum+arr[i]);

        return plus + minus;
    }
}
