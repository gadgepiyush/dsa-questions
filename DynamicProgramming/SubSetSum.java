package solvedArchive.DynamicProgramming;

public class SubSetSum {
    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int k = 9;

        System.out.println(subsetSumTab(arr.length, k, arr));
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

    static boolean subsetSumTab(int n, int k, int arr[]){
        boolean dp[][] = new boolean[n+1][k+1];

        for(int i=0 ; i<=n ; i++)
            dp[i][0] = true;

        for(int i=1 ; i<=n ; i++){
            for(int currSum=1 ; currSum<=k ; currSum++){
                if(arr[i-1] <= currSum){
                    dp[i][currSum] = dp[i-1][currSum] || dp[i-1][currSum-arr[i-1]];
                }
                else{
                    dp[i][currSum] = dp[i-1][currSum];
                }
            }
        }

        return dp[n][k];
    }
}















