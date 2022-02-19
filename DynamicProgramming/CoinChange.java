package solvedArchive.DynamicProgramming;

public class CoinChange{
    public static void main(String[] args) {
        int arr[] = {1,2, 5};
        int memo[][] = new int[3][6];
        System.out.println(coinChange2(0, 5, arr, memo));
    }

    //leetcode-322 coin-change (min no of coins)
    static int coinChange(int currSum, int arr[], int memo[]){
        if(currSum==0)
            return 0;

        if(currSum<0)
            return -1;

        if(memo[currSum] != 0)
            return memo[currSum];

        int minCoins = Integer.MAX_VALUE;
        for(int i : arr){
            int temp = coinChange(currSum-i, arr, memo);

            if(temp>=0)
                minCoins = Math.min(minCoins, temp+1);
        }

        memo[currSum] = minCoins==Integer.MAX_VALUE ? -1 : minCoins;

        return memo[currSum];
    }


    //leetcode-518 coin change-2 (no of combinations)
    static int coinChange2(int idx,int currSum, int arr[], int memo[][]){
        if(currSum==0)
            return 1;


        if(memo[idx][currSum]!=0)
            return memo[idx][currSum];

        int total = 0;
        for(int i=idx ; i<arr.length ; i++){
            if(currSum-arr[i]>=0)
                total += coinChange2(i, currSum-arr[i], arr, memo);
        }

        memo[idx][currSum] = total;

        return total;
    }


    //coin change no of permutations
    static int coinChange3(int currSum, int arr[], int memo[]){
        if(currSum==0)
            return 1;

        if(memo[currSum]!=0)
            return memo[currSum];

        int total = 0;
        for(int i : arr){
            if(currSum-i>=0){
                total += coinChange3(currSum- i, arr, memo);
            }
        }

        memo[currSum] = total;

        return total;
    }

}
