package solvedArchive.DynamicProgramming;

//leetcode 70
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbingStairs(10));
    }

    static int climbingStairs(int n){
        return climbingStairsHelper(n, new int[n+1]);
    }

    static int climbingStairsHelper(int n, int arr[]){
        if(n<0)
            return 0;

        if(n==0)
            return 1;

        if(arr[n]!=0)
            return arr[n];

        arr[n] = climbingStairsHelper(n-1, arr) + climbingStairsHelper(n-2, arr);

        return arr[n];
    }
}
