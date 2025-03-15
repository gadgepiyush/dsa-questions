package solvedArchive.DynamicProgramming;

import java.util.Arrays;

public class MInCostOfClimbingStairs {
    public static void main(String[] args) {
        int arr[] = {1,100,1,1,1,100,1,1,100,1};

        System.out.println(minCostClimbingStairsTab(arr));
    }

    static int minCostClimbingStairs(int[] cost) {
        int memo[] = new int[cost.length+1];
        Arrays.fill(memo, -1);
        return helper(-1, cost, memo);
    }

    static int helper(int i, int cost[], int memo[]){
        if(i>=cost.length)
            return 0;

        if(i>-1 && memo[i]!=-1)
            return memo[i];

        int currNum = i==-1 ? 0 : cost[i];

        int min = Math.min(helper(i+1, cost, memo), helper(i+2, cost, memo)) + currNum;

        if(!(i<0))
            memo[i] = min;

        return min;
    }

    static int minCostClimbingStairsTab(int cost[]){
        int n = cost.length;
        int tab[] = new int[n+1];

        for(int i= 2 ; i<=n ; i++){
            tab[i] = Math.min(cost[i-1] + tab[i-1],
                    cost[i-2] + tab[i-2]);
        }

        return tab[n];
    }
}
